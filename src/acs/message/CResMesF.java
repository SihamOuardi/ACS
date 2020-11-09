package acs.message;

/*
 * ACS --> 3DS
 */
public class CResMesF {

	public String threeDSServerTransID ;
	public String  acsCounterAtoS;
	public String acsTransID;
	public String challengeCompletionInd;
	
	public MessageExtension[] messageExtension;
	public String messageType;
	public String messageVersion ;
	public String sdkTransID;
	
	public String transStatus;
	
	
	
	public CResMesF() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CResMesF(String threeDSServerTransID, String acsCounterAtoS, String acsTransID, String challengeCompletionInd,
			MessageExtension[] messageExtension, String messageType, String messageVersion, String sdkTransID, String transStatus) {
		super();
		this.threeDSServerTransID = threeDSServerTransID;
		this.acsCounterAtoS = acsCounterAtoS;
		this.acsTransID = acsTransID;
		this.challengeCompletionInd = challengeCompletionInd;
		this.messageExtension = messageExtension;
		this.messageType = messageType;
		this.messageVersion = messageVersion;
		this.sdkTransID = sdkTransID;
		this.transStatus = transStatus;
	}
	public String getThreeDSServerTransID() {
		return threeDSServerTransID;
	}
	public void setThreeDSServerTransID(String threeDSServerTransID) {
		this.threeDSServerTransID = threeDSServerTransID;
	}
	public String getAcsCounterAtoS() {
		return acsCounterAtoS;
	}
	public void setAcsCounterAtoS(String acsCounterAtoS) {
		this.acsCounterAtoS = acsCounterAtoS;
	}
	public String getAcsTransID() {
		return acsTransID;
	}
	public void setAcsTransID(String acsTransID) {
		this.acsTransID = acsTransID;
	}
	public String getChallengeCompletionInd() {
		return challengeCompletionInd;
	}
	public void setChallengeCompletionInd(String challengeCompletionInd) {
		this.challengeCompletionInd = challengeCompletionInd;
	}
	public MessageExtension[] getMessageExtension() {
		return messageExtension;
	}
	public void setMessageExtension(MessageExtension[] messageExtension) {
		this.messageExtension = messageExtension;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageVersion() {
		return messageVersion;
	}
	public void setMessageVersion(String messageVersion) {
		this.messageVersion = messageVersion;
	}
	public String getSdkTransID() {
		return sdkTransID;
	}
	public void setSdkTransID(String sdkTransID) {
		this.sdkTransID = sdkTransID;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	
}
