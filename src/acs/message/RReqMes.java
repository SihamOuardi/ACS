package acs.message;

import java.util.Map;

/* Results 
 * ACS --> 3DS
 */
public class RReqMes {
  public String threeDSServerTransID;
  public String acsTransID;
  public Map<String, String> acsRenderingType;
  public String authenticationMethod;
  public String authenticationType;
  public String authenticationValue;
  public String challengeCancel;
  public String dsTransID;
  public String eci;
  public String interactionCounter;
  public String messageCategory;
  public MessageExtension[] messageExtension;
  public String messageType;
  public String messageVersion;
  public String sdkTransID;
  public String transStatus;
  public String transStatusReason;
  public String whiteListStatus;
  public String whiteListStatusSource;
  
  public RReqMes() {
	  
  }
  
	public RReqMes(String threeDSServerTransID, String acsTransID, Map<String, String> acsRenderingType, String authenticationMethod,
			String authenticationType, String authenticationValue, String challengeCancel, String dsTransID, String eci,
			String interactionCounter, String messageCategory, MessageExtension[] messageExtension, String messageType,
			String messageVersion, String sdkTransID, String transStatus, String transStatusReason, String whiteListStatus,
			String whiteListStatusSource) {
		super();
		this.threeDSServerTransID = threeDSServerTransID;
		this.acsTransID = acsTransID;
		this.acsRenderingType = acsRenderingType;
		this.authenticationMethod = authenticationMethod;
		this.authenticationType = authenticationType;
		this.authenticationValue = authenticationValue;
		this.challengeCancel = challengeCancel;
		this.dsTransID = dsTransID;
		this.eci = eci;
		this.interactionCounter = interactionCounter;
		this.messageCategory = messageCategory;
		this.messageExtension = messageExtension;
		this.messageType = messageType;
		this.messageVersion = messageVersion;
		this.sdkTransID = sdkTransID;
		this.transStatus = transStatus;
		this.transStatusReason = transStatusReason;
		this.whiteListStatus = whiteListStatus;
		this.whiteListStatusSource = whiteListStatusSource;
	}
	public String getThreeDSServerTransID() {
		return threeDSServerTransID;
	}
	public void setThreeDSServerTransID(String threeDSServerTransID) {
		this.threeDSServerTransID = threeDSServerTransID;
	}
	public String getAcsTransID() {
		return acsTransID;
	}
	public void setAcsTransID(String acsTransID) {
		this.acsTransID = acsTransID;
	}
	public Map<String, String> getAcsRenderingType() {
		return acsRenderingType;
	}
	public void setAcsRenderingType(Map<String, String> acsRenderingType) {
		this.acsRenderingType = acsRenderingType;
	}
	public String getAuthenticationMethod() {
		return authenticationMethod;
	}
	public void setAuthenticationMethod(String authenticationMethod) {
		this.authenticationMethod = authenticationMethod;
	}
	public String getAuthenticationType() {
		return authenticationType;
	}
	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}
	public String getAuthenticationValue() {
		return authenticationValue;
	}
	public void setAuthenticationValue(String authenticationValue) {
		this.authenticationValue = authenticationValue;
	}
	public String getChallengeCancel() {
		return challengeCancel;
	}
	public void setChallengeCancel(String challengeCancel) {
		this.challengeCancel = challengeCancel;
	}
	public String getDsTransID() {
		return dsTransID;
	}
	public void setDsTransID(String dsTransID) {
		this.dsTransID = dsTransID;
	}
	public String getEci() {
		return eci;
	}
	public void setEci(String eci) {
		this.eci = eci;
	}
	public String getInteractionCounter() {
		return interactionCounter;
	}
	public void setInteractionCounter(String interactionCounter) {
		this.interactionCounter = interactionCounter;
	}
	public String getMessageCategory() {
		return messageCategory;
	}
	public void setMessageCategory(String messageCategory) {
		this.messageCategory = messageCategory;
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
	public String getTransStatusReason() {
		return transStatusReason;
	}
	public void setTransStatusReason(String transStatusReason) {
		this.transStatusReason = transStatusReason;
	}
	public String getWhiteListStatus() {
		return whiteListStatus;
	}
	public void setWhiteListStatus(String whiteListStatus) {
		this.whiteListStatus = whiteListStatus;
	}
	public String getWhiteListStatusSource() {
		return whiteListStatusSource;
	}
	public void setWhiteListStatusSource(String whiteListStatusSource) {
		this.whiteListStatusSource = whiteListStatusSource;
	}

  
}
