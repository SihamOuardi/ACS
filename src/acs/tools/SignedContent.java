package acs.tools;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.apache.commons.logging.impl.Log4JLogger;

import acs.message.AReqMes;
import acs.message.detailMsg.SdkEphemPubKey;
import net.sf.json.JSONObject;
import security.ConstScurity;

public class SignedContent {
	public  static Log4JLogger logger = new Log4JLogger();

	public  static String calculateSignedContent(AReqMes aReqMes){		
		String signedContent = null;
		logger.info(" calculateSignedContent -- > " + aReqMes.getSdkEphemPubKey());
		try {
		/*
		 * {kty=EC, crv=P-256,
		 *  x=WWcpTjbOqiu_1aODllw5rYTq5oLXE_T0huCPjMIRbkI, 
		 * y=Wz_7anIeadV8SJZUfr4drwjzuWoUbOsHp5GdRZBAAiw}
		 */
		
		SdkEphemPubKey acsEphemPubKey =new SdkEphemPubKey("EC","P-256","mPUKT_bAWGHIhg0TpjjqVsP1rXWQu_vwVOHHtNkdYoA","8BQAsImGeAS46fyWw5MhYfGTT0IjBpFw2SS34Dv4Irs");
		SdkEphemPubKey sdkEphemPubKey =new SdkEphemPubKey("EC","P-256","Ze2loSV3wrroKUN_4zhwGhCqo3Xhu1td4QjeQ5wIVR0","HlLtdXARY_f55A3fnzQbPcm6hgr34Mp8p-nuzQCE0Zw");
		String acsURL = ConstScurity.ACSURLBRW;
		
		JSONObject obj = new JSONObject();

	      obj.put("acsEphemPubKey", acsEphemPubKey);
	      obj.put("sdkEphemPubKey", sdkEphemPubKey);
	      obj.put("acsURL", acsURL);
	      String JsonWithoutSpace = obj.toString();	      
		  logger.info(" JsonWithoutSpace  " + JsonWithoutSpace);
		
		String Encoded64Signed = Base64.getEncoder().encodeToString(JsonWithoutSpace.getBytes("utf-8"));
		logger.info(" Encoded64Signed  " + Encoded64Signed);

		  
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  
		
		return signedContent;
	}
}
