package acs.tools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;

import acs.message.RReqMes;

public class SendRReq {

	private static Boolean statut = false ;
	
	public static boolean sendRReqMes(RReqMes rReqMes, String DSUrl) {
		
		String path = "/opt/wildfly/Keystore/eps_acs_client.jks";
		char[] passphrase =  "Eps@2015".toCharArray();
		String certificateName = "eps_acs_client"; 

		try {
			SSLSocketFactory sslFactory = null;
		
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType()); 
		keyStore.load(new FileInputStream(path), passphrase);
		

		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		
		tmf.init(keyStore);

		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");


		keyManagerFactory.init(keyStore, passphrase);

        
		KeyManager[] kms = keyManagerFactory.getKeyManagers();
        for (int i = 0; i < kms.length; i++) {
            if (kms[i] instanceof X509KeyManager) {
                kms[i] = new AliasForcingKeyManager((X509KeyManager) kms[i], certificateName);
            }
        }
        // END   MAW20200617
		////////////////////////////////////////
/**/
		// java.lang.System.setProperty("https.protocols","TLSv1,TLSv1.1,TLSv1.2");
		java.lang.System.setProperty("https.protocols","TLSv1.1,TLSv1.2");  // MAW20200622

		SSLContext ctx = SSLContext.getInstance("TLSv1.2");
		
		// ctx.init(null, tmf.getTrustManagers(), new SecureRandom());
		
		ctx.init(kms, tmf.getTrustManagers(), new SecureRandom()); // MAW20200617
		
		sslFactory = ctx.getSocketFactory();
		
		URL url = new URL(DSUrl);
        
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

		conn.setSSLSocketFactory(sslFactory); 

		conn.setRequestMethod("POST");
		
		conn.addRequestProperty("Content-Type", "application/xml; charset=utf-8");
		conn.addRequestProperty("Content-Length", rReqMes.toString().length() + "");

		
		conn.setDoOutput(true);
		
		conn.connect();
		
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		
		wr.write(rReqMes.toString().getBytes());
		wr.flush();
		wr.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String input;
		StringBuffer sb = new StringBuffer();
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		
		br.close();

	} catch (Exception e) {
	       e.getMessage();
	}
		return statut;
	}
}
