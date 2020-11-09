package acs.construct;

import org.apache.commons.logging.impl.Log4JLogger;

import com.sun.media.jfxmedia.logging.Logger;

import acs.message.AReqMes;
import acs.message.AResMes;
import acs.message.CReqMes;
import acs.message.CResMes;
import acs.message.CResMesF;
import acs.message.ErrorMes;
import acs.message.RReqMes;
import acs.tools.GenerateShortUUID;
import acs.tools.SignedContent;
import security.ConstScurity;

public class ConstructMsg {

	// construct AResMes
	public  static Log4JLogger logger = new Log4JLogger();

	public static String generateACSID() {
		String AcsTransID = GenerateShortUUID.next();
		return AcsTransID;
	}
	
	public static AResMes constructAresMes(AResMes aResMes  , AReqMes aReqMes) {
		
		
		aResMes.setMessageVersion(aReqMes.getMessageVersion());
		aResMes.setDsTransID(aReqMes.getDsTransID());
		aResMes.setMessageType(ConstScurity.messageTypeARes);
		aResMes.setThreeDSServerTransID(aReqMes.getThreeDSServerTransID());
		aResMes.setAcsReferenceNumber(aReqMes.getAcsReferenceNumber());
		aResMes.setCardholderInfo(aReqMes.getCardholderInfo());
		aResMes.setBroadInfo(aReqMes.getBroadInfo());
		aResMes.setAcsOperatorID("AcsOpId 4138359541");
		aResMes.setDsReferenceNumber(aReqMes.getDsReferenceNumber());
		aResMes.setMessageExtension(aReqMes.getMessageExtension());
		// if Status == C or D  AcsChallengeMandated is required Y or N 
		//aResMes.setTransStatus("C");
		aResMes.setAuthenticationType(ConstScurity.AuthType02);
		aResMes.setAcsChallengeMandated("Y");
		
		String  AntMethod = aReqMes.getThreeDSRequestorPriorAuthenticationInfo().getThreeDSReqPriorAuthMethod();
		logger.info("Antrior Method  " + AntMethod);
		
		if(aReqMes.getDeviceChannel().equals("02")) {
			aResMes.setAcsURL(ConstScurity.ACSURLBRW);// will be use to send CREQ to the ACS
       }
		else if(aReqMes.getDeviceChannel().equals("01")){
			String signedContent = SignedContent.calculateSignedContent(aReqMes);
			 aResMes.setAcsSignedContent(signedContent);// will be use to send CREQ to the ACS		
		}
				
		return aResMes;		
	}
		
	public static RReqMes constructRReqMes(AResMes aResMes  , AReqMes aReqMes, RReqMes rReqMes ) {
		rReqMes.setAcsRenderingType(aResMes.getAcsRenderingType());
		rReqMes.setAcsTransID(aResMes.getAcsTransID());
		rReqMes.setAuthenticationMethod(ConstScurity.AuthMethod01);
		rReqMes.setAuthenticationType(aResMes.getAuthenticationType());
		rReqMes.setDsTransID(aResMes.getDsTransID());
		rReqMes.setEci(aResMes.getEci());
		rReqMes.setInteractionCounter("");
		rReqMes.setMessageCategory(aReqMes.getMessageCategory());
		rReqMes.setMessageVersion(ConstScurity.Msg_Active_2);
		rReqMes.setMessageType(ConstScurity.messageTypeRReq);
		rReqMes.setMessageExtension(aResMes.getMessageExtension());
		rReqMes.setChallengeCancel("");
		rReqMes.setAuthenticationValue(aResMes.getAuthenticationValue());
		rReqMes.setThreeDSServerTransID("");
		
		return rReqMes;		
	}

	
	public static CResMesF constructCResMesF(AResMes aResMes  , CResMes cResMes, CResMesF cResMesF  ) {
		
		cResMesF.setAcsTransID(aResMes.getAcsTransID());
		cResMesF.setChallengeCompletionInd("");
		
		cResMesF.setMessageVersion(ConstScurity.Msg_Active_2);
		cResMesF.setMessageType(ConstScurity.messageTypeRReq);		
		cResMesF.setMessageExtension(aResMes.getMessageExtension());
		cResMesF.setAcsCounterAtoS("");
		
		cResMesF.setSdkTransID(aResMes.getSdkTransID());
		cResMesF.setThreeDSServerTransID(aResMes.getThreeDSServerTransID());
		cResMesF.setTransStatus(aResMes.getTransStatus());
		
		return cResMesF;		
	}
	
	
  public static CResMes constructCResMes(AResMes aResMes  , AReqMes aReqMes, CResMes cResMes  ) {
		
	  cResMes.setAcsTransID(aResMes.getAcsTransID());
	  cResMes.setChallengeCompletionInd("");		
	  cResMes.setMessageVersion(ConstScurity.Msg_Active_2);
	  cResMes.setMessageType(ConstScurity.messageTypeRReq);		
	  cResMes.setMessageExtension(aResMes.getMessageExtension());
	  cResMes.setAcsCounterAtoS("");		
	  cResMes.setSdkTransID(aResMes.getSdkTransID());
	  cResMes.setThreeDSServerTransID(aResMes.getThreeDSServerTransID());		
	  cResMes.setAcsHTML("");
	  cResMes.setAcsUiType("");
	  cResMes.setOobAppLabel("");
	  cResMes.setOobAppURL("");
	  cResMes.setOobContinueLabel("");
	  cResMes.setChallengeInfoHeader("");
	  cResMes.setChallengeInfoLabel("");
	  cResMes.setChallengeInfoText("");
	  cResMes.setChallengeInfoTextIndicator("");
	  cResMes.setChallengeSelectInfo("");
	  cResMes.setExpandInfoLabel("");
	  cResMes.setExpandInfoText("");
	  cResMes.setWhitelistingInfoText("");
	  cResMes.setWhyInfoLabel("");
	  cResMes.setWhyInfoText("");
	  
	  
	  return cResMes;		
	}

}
