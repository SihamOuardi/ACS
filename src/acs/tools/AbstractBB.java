package acs.tools;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.impl.Log4JLogger;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class AbstractBB {
	
	private Map<String, String> otpMap = new HashMap<>();
	public static final Log4JLogger logger = new Log4JLogger(AbstractBB.class.getName());
	
	
	public String sendOTP(String mobile, String mail) throws Exception {
		Random rand = new Random();
		String otp = String.format("%06d", rand.nextInt(999999));
		otpMap.put(mobile, otp);
		try {
			logger.info("YOUR PASSWORD FOR THIS TRANSACTION IS " + otp);
		} catch (Exception e) {
			logger.info(e);
			throw e;
		}
		return otp;
	}

	protected void printMessage(String msg, FacesMessage.Severity severity) {

		BuildMessage.addMessageFromBundle("LoginMsg", msg, msg, null, severity,
				null);
	}

	public String navigateTo(String pagexhtml) {
		FacesContext fctx = FacesContext.getCurrentInstance();
		ExternalContext ectx = fctx.getExternalContext();
		String url = ((HttpServletRequest) ectx.getRequest()).getContextPath()
				+ "/" + pagexhtml + ".xhtml";
		try {
			ectx.redirect(url);
		} catch (IOException e) {
			logger.info(e);
		}

		return null;
	}

	public static String getPhysicalPath() {
		String physicalPath = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");
		if (physicalPath.endsWith(File.separator))
			physicalPath += File.separator;
		return physicalPath;
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();

		return sdfDate.format(now);
	}

	public String getFldFromXML(Document doc, String xmlParentNode,
			String xmlSubNode) {
		NodeList nodes = doc.getElementsByTagName(xmlParentNode);
		Element element = (Element) nodes.item(0);
		NodeList item = element.getElementsByTagName(xmlSubNode);

		return getCharacterDataFromElement((Element) item.item(0));
	}

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

	public static String getIPAdress() {
		String remoteAddr = null;
		FacesContext fctx = FacesContext.getCurrentInstance();
		ExternalContext ectx = fctx.getExternalContext();
		ectx.getRemoteUser();

		Object reqOb = fctx.getExternalContext().getRequest();
		if (reqOb instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) reqOb;
			if (req.getHeader("HTTP_X_FORWARDED_FOR") == null)
				remoteAddr = req.getRemoteAddr();
			else
				remoteAddr = req.getHeader("HTTP_X_FORWARDED_FOR");
		}

		return remoteAddr;
	}
}
