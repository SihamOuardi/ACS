package acs.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.xml.security.utils.IdResolver;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Example to sign an XML and validate it using java internal libraries.
 * 
 * Copyright (C) 2015 Dennis Natanzon
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
public class Signing {

	private Signing() {
	}

	static Logger logger = java.util.logging.Logger.getLogger("Signing");

	private static Document parseXml(String xmlFilePath) {
		logger.info("parseXml ...");

		DocumentBuilder db;
		Document doc = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlFilePath));

			doc = db.parse(is);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public static Element getElement(String name, Document doc) {
		NodeList nodes = doc.getElementsByTagName(name);
		Element el = null;
		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);
			el = element;
		}
		return el;
	}

	public static String signPaRes(String xmlData) {
		String signed = null;
		try {
			logger.info("signPaRes Creating a XML Signature Factory...");

			X509Certificate root = getRootCert();
			X509Certificate intermediate = getIntermediateCert();
			X509Certificate signing = getSignCert();
			logger.info("signPaRes Creating a XML Signature Factory...");
			// Create a DOM XMLSignatureFactory that will be used to
			// generate the enveloped signature.
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance();

			// Create a Reference to the enveloped document (in this case,
			// you are signing the whole document, so a URI of "" signifies
			// that, and also specify the SHA1 digest algorithm and
			// the ENVELOPED Transform.
			logger.info("Creating a reference to the enveloped document...");
			Reference ref;

			/** MAW20200629
			ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, // SHA256
					null), Collections.singletonList(fac.newTransform(
					Transform.ENVELOPED, (TransformParameterSpec) null)), null,
					null);
			**/
			
			if(xmlData.contains("<PARes")){
				List<Transform> transforms = new ArrayList<Transform>(2);
	
				Map<String, String> namespaces = new HashMap<String, String>();
	
				XPathFilterParameterSpec paramsXpath = new XPathFilterParameterSpec("/PARes", namespaces);
	
				transforms.add(fac.newTransform(Transform.XPATH, (TransformParameterSpec) paramsXpath));
	
				Transform transformObj = fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);
				transforms.add(transformObj);
			    DigestMethod digestMethod = fac.newDigestMethod(DigestMethod.SHA1, null);
	
				ref = fac.newReference("", digestMethod, transforms, null, null);
			}
			else {
				ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, // SHA256
						null), Collections.singletonList(fac.newTransform(
						Transform.ENVELOPED, (TransformParameterSpec) null)), null,
						null);
			}

			// Create the SignedInfo.
			logger.info("Creating a Signed Info...");
			SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE,
					(C14NMethodParameterSpec) null), fac.newSignatureMethod(
			// "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"
					SignatureMethod.RSA_SHA1, null), Collections
					.singletonList(ref));

			// Instantiate the document to be signed.
			logger.info("Instantiate the document to be signed...");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);

			Document doc = parseXml(xmlData);

			// Create the KeyInfo containing the X509Data.
			KeyInfoFactory kif = fac.getKeyInfoFactory();
			List<Serializable> x509Content = new ArrayList<>();
			x509Content.add(root.getSubjectX500Principal().getName());
			x509Content.add(root);
			x509Content.add(intermediate);
			x509Content.add(signing);
			/*
			 * logger.info("size : " + getCertChain().length); for (Certificate
			 * c : getCertChain()) { logger.info(c.getType());
			 * x509Content.add(c); }
			 */

			/*
			 * for (X509Certificate c : x509Content) { logger.info(c.getType());
			 * }
			 */

			X509Data xd = kif.newX509Data(x509Content);
			KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

			// Create a DOMSignContext and specify the RSA PrivateKey and
			// location of the resulting XMLSignature's parent element.
			logger.info("Creating a DomSignContext with our privateKey...");
			Element message = getElement("Message", doc);
			DOMSignContext dsc = new DOMSignContext(getKeyEntry()
					.getPrivateKey(), message);

			// Create the XMLSignature, but don't sign it yet.
			logger.info("Creating the XMLsignature but don't sign it...");
			XMLSignature signature = fac.newXMLSignature(si, ki);

			// Marshal, generate, and sign the enveloped signature.
			logger.info("Marshal, generate and sign the enveloped signature...");
			signature.sign(dsc);

			// Output the resulting document.
			// OutputStream os = new
			// FileOutputStream("signedPurchaseOrder.xml");
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			// trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			// trans.transform(new DOMSource(doc), new StreamResult(os));

			// trans = tf.newTransformer();
			StringWriter writer = new StringWriter();
			trans.transform(new DOMSource(doc), new StreamResult(writer));
			signed = writer.getBuffer().toString();
		} catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException
				| IOException | TransformerException | MarshalException
				| XMLSignatureException | KeyStoreException
				| CertificateException | UnrecoverableEntryException
				| NamingException e) {
			e.printStackTrace();
		}

		return signed;
	}
	
	static public String signPaResURI(String xmlData) {
		String signed = null;
		try {
			
			
			/**
			org.apache.xml.security.Init.init(); // 
			Canonicalizer canon = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_OMIT_COMMENTS);
			byte canonXmlBytes[] = canon.canonicalize(xmlData.getBytes());
			xmlData = new String(canonXmlBytes);
			**/
			
			X509Certificate root = getRootCert();
			X509Certificate intermediate = getIntermediateCert();
			X509Certificate signing = getSignCert();
			System.out.println("Creating a XML Signature Factory...");
			// Create a DOM XMLSignatureFactory that will be used to
			// generate the enveloped signature.
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance();
			
			Document doc = parseXml(xmlData);

			// Create a Reference to the enveloped document (in this case,
			// you are signing the whole document, so a URI of "" signifies
			// that, and also specify the SHA1 digest algorithm and
			// the ENVELOPED Transform.
			System.out.println("Creating a reference to the enveloped document...");
			Reference ref;
			
			XPathFactory xPathfactory = XPathFactory.newInstance();
	        XPath xpath = xPathfactory.newXPath();

	        XPathExpression expr = xpath.compile("//ThreeDSecure/Message/PARes[@id]");			
	        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
	        // Element paresNode = (Element) nl.item(0);    
	        Element paresNode = (Element) expr.evaluate(doc, XPathConstants.NODE);
	        String paresId = paresNode.getAttributes().getNamedItem("id").getNodeValue();
            System.out.println("PARes.ID=["+paresId+"]");
            
            Attr attrId = paresNode.getAttributeNode("id");
            IdResolver.registerElementById(paresNode, attrId);
            ((Element)attrId.getOwnerElement()).setIdAttributeNode(attrId,true);

            
			ref = fac.newReference("#"+paresId, fac.newDigestMethod(DigestMethod.SHA1, // SHA256
			// ref = fac.newReference("#"+paresId, fac.newDigestMethod(DigestMethod.SHA1, // SHA256
					null), Collections.singletonList(fac.newTransform(
					Transform.ENVELOPED, (TransformParameterSpec) null)), null,
					null);
            
	        
			// Create the SignedInfo.
			System.out.println("Creating a Signed Info...");
			SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE,
					(C14NMethodParameterSpec) null), fac.newSignatureMethod(
			// "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"
					SignatureMethod.RSA_SHA1, null), Collections
					.singletonList(ref));

			// Create the KeyInfo containing the X509Data.
			KeyInfoFactory kif = fac.getKeyInfoFactory();
			List<Serializable> x509Content = new ArrayList<>();
			x509Content.add(root.getSubjectX500Principal().getName());
			x509Content.add(root);
			x509Content.add(intermediate);
			x509Content.add(signing);
			/*
			 * System.out.println("size : " + getCertChain().length); for (Certificate
			 * c : getCertChain()) { System.out.println(c.getType());
			 * x509Content.add(c); }
			 */

			/*
			 * for (X509Certificate c : x509Content) { System.out.println(c.getType());
			 * }
			 */

			X509Data xd = kif.newX509Data(x509Content);
			KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

			// Create a DOMSignContext and specify the RSA PrivateKey and
			// location of the resulting XMLSignature's parent element.
			System.out.println("Creating a DomSignContext with our privateKey...");
			Element message = getElement("Message", doc);
			DOMSignContext dsc = new DOMSignContext(getKeyEntry().getPrivateKey(), message);
			// DOMSignContext dsc = new DOMSignContext(getKeyEntry().getPrivateKey(), message, paresNode);
			

			// Create the XMLSignature, but don't sign it yet.
			System.out.println("Creating the XMLsignature but don't sign it...");
			XMLSignature signature = fac.newXMLSignature(si, ki);

			// Marshal, generate, and sign the enveloped signature.
			System.out.println("Marshal, generate and sign the enveloped signature...");
			signature.sign(dsc);

			// Output the resulting document.
			// OutputStream os = new
			// FileOutputStream("signedPurchaseOrder.xml");
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			// trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			// trans.transform(new DOMSource(doc), new StreamResult(os));

			// trans = tf.newTransformer();
			StringWriter writer = new StringWriter();
			trans.transform(new DOMSource(doc), new StreamResult(writer));
			signed = writer.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return signed;
	}

	private static X509Certificate getSignCert()
			throws NoSuchAlgorithmException, UnrecoverableEntryException,
			KeyStoreException, CertificateException, IOException,
			NamingException {
		logger.info(" getSignCert ++ Load the keystore stored in this project to get our keys and certificate...");
		// Load the KeyStore and get the signing key and certificate.
		Context env = (Context) new InitialContext().lookup("java:comp/env");
		// Get a single value
		String keyStore = (String) env.lookup("keyStore");
		String keyPass = (String) env.lookup("keyPass");
		String keyAlias = (String) env.lookup("self");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(keyStore), keyPass.toCharArray());
		// KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry)
		// ks.getEntry(keyAlias,new
		// KeyStore.PasswordProtection(keyPass.toCharArray()));
		// return (X509Certificate) keyEntry.getCertificate();
		return (X509Certificate) ks.getCertificate(keyAlias);
	}

	public static X509Certificate getIntermediateCert()
			throws NoSuchAlgorithmException, UnrecoverableEntryException,
			KeyStoreException, CertificateException, IOException,
			NamingException {
		logger.info(" getIntermediateCert Load the keystore stored in this project to get our keys and certificate...");
		// Load the KeyStore and get the signing key and certificate.
		Context env = (Context) new InitialContext().lookup("java:comp/env");
		// Get a single value
		String keyStore = (String) env.lookup("keyStore");
		String keyPass = (String) env.lookup("keyPass");
		String keyAlias = (String) env.lookup("intermediate");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(keyStore), keyPass.toCharArray());
		// KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry)
		// ks.getEntry(keyAlias,new
		// KeyStore.PasswordProtection(keyPass.toCharArray()));
		// return (X509Certificate) keyEntry.getCertificate();
		return (X509Certificate) ks.getCertificate(keyAlias);

	}

	public static String signXML(String xmlData) {
		String signed = null;
		try {
			X509Certificate cert = getRootCert();
			logger.info("signXML Creating a XML Signature Factory...");
			// Create a DOM XMLSignatureFactory that will be used to
			// generate the enveloped signature.
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance();

			// Create a Reference to the enveloped document (in this case,
			// you are signing the whole document, so a URI of "" signifies
			// that, and also specify the SHA1 digest algorithm and
			// the ENVELOPED Transform.
			logger.info("Creating a reference to the enveloped document...");
			Reference ref;

			ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, // SHA256
					null), Collections.singletonList(fac.newTransform(
					Transform.ENVELOPED, (TransformParameterSpec) null)), null,
					null);

			// Create the SignedInfo.
			logger.info("Creating a Signed Info...");
			SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE,
					(C14NMethodParameterSpec) null), fac.newSignatureMethod(
			// "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"
					SignatureMethod.RSA_SHA1, null), Collections
					.singletonList(ref));

			// Instantiate the document to be signed.
			logger.info("Instantiate the document to be signed...");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);

			Document doc = parseXml(xmlData);

			// Create the KeyInfo containing the X509Data.
			KeyInfoFactory kif = fac.getKeyInfoFactory();
			List<Serializable> x509Content = new ArrayList<>();
			x509Content.add(cert.getSubjectX500Principal().getName());
			x509Content.add(cert);
			X509Data xd = kif.newX509Data(x509Content);
			KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

			// Create a DOMSignContext and specify the RSA PrivateKey and
			// location of the resulting XMLSignature's parent element.
			logger.info("Creating a DomSignContext with our privateKey...");
			DOMSignContext dsc = new DOMSignContext(getKeyEntry()
					.getPrivateKey(), doc.getDocumentElement());

			// Create the XMLSignature, but don't sign it yet.
			logger.info("Creating the XMLsignature but don't sign it...");
			XMLSignature signature = fac.newXMLSignature(si, ki);

			// Marshal, generate, and sign the enveloped signature.
			logger.info("Marshal, generate and sign the enveloped signature...");
			signature.sign(dsc);

			// Output the resulting document.
			// OutputStream os = new
			// FileOutputStream("signedPurchaseOrder.xml");
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			// trans.transform(new DOMSource(doc), new StreamResult(os));

			// trans = tf.newTransformer();
			StringWriter writer = new StringWriter();
			trans.transform(new DOMSource(doc), new StreamResult(writer));
			signed = writer.getBuffer().toString();
		} catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException
				| IOException | TransformerException | MarshalException
				| XMLSignatureException | KeyStoreException
				| CertificateException | UnrecoverableEntryException
				| NamingException e) {
			e.printStackTrace();
		}

		return signed;
	}

	public static boolean validateXML(String receivedMessage) throws Exception {
		// Validate our created signedPurchaseOrder.xml with our provided public
		// key.
		X509Certificate cert = getRootCert();
		logger.info("validateXML Validate ...");
		return new Validation().validate(cert.getPublicKey(), receivedMessage);
	};

	public static X509Certificate getRootCert()
			throws NoSuchAlgorithmException, UnrecoverableEntryException,
			KeyStoreException, CertificateException, IOException,
			NamingException {
		logger.info("getRootCert Load the keystore stored in this project to get our keys and certificate...");
		// Load the KeyStore and get the signing key and certificate.
		Context env = (Context) new InitialContext().lookup("java:comp/env");
		// Get a single value
		String keyStore = (String) env.lookup("keyStore");
		String keyPass = (String) env.lookup("keyPass");
		String keyAlias = (String) env.lookup("root");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(keyStore), keyPass.toCharArray());
		// KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry)
		// ks.getEntry(keyAlias,new
		// KeyStore.PasswordProtection(keyPass.toCharArray()));
		// return (X509Certificate) keyEntry.getCertificate();
		return (X509Certificate) ks.getCertificate(keyAlias);

	}

	public static Certificate[] getCertChain() throws NoSuchAlgorithmException,
			UnrecoverableEntryException, KeyStoreException,
			CertificateException, IOException, NamingException {
		logger.info("getCertChain Load the keystore stored in this project to get our keys and certificate...");
		// Load the KeyStore and get the signing key and certificate.
		Context env = (Context) new InitialContext().lookup("java:comp/env");
		// Get a single value
		String keyStore = (String) env.lookup("keyStore");
		String keyPass = (String) env.lookup("keyPass");
		String keyAlias = (String) env.lookup("alias");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(keyStore), keyPass.toCharArray());
		KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) ks
				.getEntry(keyAlias,
						new KeyStore.PasswordProtection(keyPass.toCharArray()));
		// return keyEntry.getCertificateChain();

		// Load certificate chain
		Certificate[] chain = ks.getCertificateChain(keyAlias);

		return chain;

	}

	public static PrivateKeyEntry getKeyEntry()
			throws NoSuchAlgorithmException, UnrecoverableEntryException,
			KeyStoreException, CertificateException, FileNotFoundException,
			IOException, NamingException {

		logger.info("getKeyEntry Load the keystore stored in this project to get our keys and certificate...");
		// Load the KeyStore and get the signing key and certificate.

		Context env = (Context) new InitialContext().lookup("java:comp/env");
		// Get a single value //
		String keyStore = (String) env.lookup("keyStore");
		String keyPass = (String) env.lookup("keyPass");
		String keyAlias = (String) env.lookup("alias");
		logger.info("keyStore " + keyStore);
		logger.info("keyPass " + keyPass);
		logger.info("keyAlias " + keyAlias);
		// String keyspass =
		// globalData.getHttpServletRequest().getServletContext().getInitParameter("keyPass");
		// String alias =
		// globalData.getHttpServletRequest().getServletContext().getInitParameter("alias");

		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(keyStore), keyPass.toCharArray());
		
		return (KeyStore.PrivateKeyEntry) ks.getEntry(keyAlias, new KeyStore.PasswordProtection(keyPass.toCharArray()));

	}

	public static PrivateKeyEntry getKeyEntrySelf()
			throws NoSuchAlgorithmException, UnrecoverableEntryException,
			KeyStoreException, CertificateException, FileNotFoundException,
			IOException, NamingException {

		logger.info("getKeyEntrySelf Load the keystore stored in this project to get our keys and certificate...");
		// Load the KeyStore and get the signing key and certificate.

		Context env = (Context) new InitialContext().lookup("java:comp/env");
		// Get a single value
		String keyStore = "/jboss/EPSLogs/jboss_eps_keystore.jks";
		String keyPass = "Diamond@2016";
		String keyAlias = "jboss_eps";
		logger.info("keyStore " + keyStore);
		// String keyspass =
		// globalData.getHttpServletRequest().getServletContext().getInitParameter("keyPass");
		// String alias =
		// globalData.getHttpServletRequest().getServletContext().getInitParameter("alias");

		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(keyStore), keyPass.toCharArray());
		return (KeyStore.PrivateKeyEntry) ks.getEntry(keyAlias,
				new KeyStore.PasswordProtection(keyPass.toCharArray()));

	}

	public static KeyInfo getKeyInfo() {
		KeyInfo ki = null;
		try {
			X509Certificate root = getRootCert();
			X509Certificate intermediate = getIntermediateCert();
			X509Certificate signing = getSignCert();
			logger.info("getKeyInfo Creating a XML Signature Factory...");
			// Create a DOM XMLSignatureFactory that will be used to
			// generate the enveloped signature.
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance();
			// Create the KeyInfo containing the X509Data.
			KeyInfoFactory kif = fac.getKeyInfoFactory();
			List<Serializable> x509Content = new ArrayList<>();
			x509Content.add(root.getSubjectX500Principal().getName());
			x509Content.add(root);
			x509Content.add(intermediate);
			x509Content.add(signing);
		
			/*
			 * logger.info("size : " + getCertChain().length); for (Certificate
			 * c : getCertChain()) { logger.info(c.getType());
			 * x509Content.add(c); }
			 */

			/*
			 * for (X509Certificate c : x509Content) { logger.info(c.getType());
			 * }
			 */

			X509Data xd = kif.newX509Data(x509Content);			
			ki = kif.newKeyInfo(Collections.singletonList(xd));
		} catch (NoSuchAlgorithmException 
				| IOException  
				 | KeyStoreException
				| CertificateException | UnrecoverableEntryException
				| NamingException e) {
			e.printStackTrace();
		}
		return ki;
	}

	public static String signDocument(String xmlData, String tag) {
		String signed = null;
		try {
			X509Certificate root = getRootCert();
			X509Certificate intermediate = getIntermediateCert();
			X509Certificate signing = getSignCert();
			logger.info("signDocument Creating a XML Signature Factory...");
			// Create a DOM XMLSignatureFactory that will be used to
			// generate the enveloped signature.
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance();

			// Create a Reference to the enveloped document (in this case,
			// you are signing the whole document, so a URI of "" signifies
			// that, and also specify the SHA1 digest algorithm and
			// the ENVELOPED Transform.
			logger.info("Creating a reference to the enveloped document...");
			Reference ref;

			ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, // SHA256
					null), Collections.singletonList(fac.newTransform(
					Transform.ENVELOPED, (TransformParameterSpec) null)), null,
					null);

			// Create the SignedInfo.
			logger.info("Creating a Signed Info...");
			SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE,
					(C14NMethodParameterSpec) null), fac.newSignatureMethod(
			// "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"
					SignatureMethod.RSA_SHA1, null), Collections
					.singletonList(ref));

			// Instantiate the document to be signed.
			logger.info("Instantiate the document to be signed...");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);

			Document doc = parseXml(xmlData);

			// Create the KeyInfo containing the X509Data.
			KeyInfoFactory kif = fac.getKeyInfoFactory();
			List<Serializable> x509Content = new ArrayList<>();
			x509Content.add(root.getSubjectX500Principal().getName());
			x509Content.add(root);
			x509Content.add(intermediate);
			x509Content.add(signing);
			/*
			 * logger.info("size : " + getCertChain().length); for (Certificate
			 * c : getCertChain()) { logger.info(c.getType());
			 * x509Content.add(c); }
			 */

			/*
			 * for (X509Certificate c : x509Content) { logger.info(c.getType());
			 * }
			 */

			X509Data xd = kif.newX509Data(x509Content);
			KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

			// Create a DOMSignContext and specify the RSA PrivateKey and
			// location of the resulting XMLSignature's parent element.
			logger.info("Creating a DomSignContext with our privateKey...");
			Element message = getElement(tag, doc);
			DOMSignContext dsc = new DOMSignContext(getKeyEntry()
					.getPrivateKey(), message);

			// Create the XMLSignature, but don't sign it yet.
			logger.info("Creating the XMLsignature but don't sign it...");
			XMLSignature signature = fac.newXMLSignature(si, ki);

			// Marshal, generate, and sign the enveloped signature.
			logger.info("Marshal, generate and sign the enveloped signature...");
			signature.sign(dsc);

			// Output the resulting document.
			// OutputStream os = new
			// FileOutputStream("signedPurchaseOrder.xml");
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			// trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			// trans.transform(new DOMSource(doc), new StreamResult(os));

			// trans = tf.newTransformer();
			StringWriter writer = new StringWriter();
			trans.transform(new DOMSource(doc), new StreamResult(writer));
			signed = writer.getBuffer().toString();
		} catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException
				| IOException | TransformerException | MarshalException
				| XMLSignatureException | KeyStoreException
				| CertificateException | UnrecoverableEntryException
				| NamingException e) {
			e.printStackTrace();
		}

		return signed;
	}

}
