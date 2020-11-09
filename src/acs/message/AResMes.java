package acs.message;

import java.util.Map;

/*
 * ACS --> 3DS
 */
public class AResMes {
	

	
	public String threeDSServerTransID ;
	public String acsChallengeMandated;
	public String acsDecConInd;
	public String acsOperatorID;
	public String acsReferenceNumber;
	public Map<String, String> acsRenderingType;
	public String acsSignedContent;
	public String acsTransID;
	public String acsURL;
	public String authenticationType;
	public String authenticationValue;
	public Map<String, String> broadInfo;
	public String cardholderInfo;
	public String dsReferenceNumber;
	public String dsTransID;
	public String eci;
	public MessageExtension[] messageExtension;
	public String messageType;
	public String messageVersion;
	public String sdkTransID;
	public String transStatus;
	public String transStatusReason;
	public String whiteListStatus;
	public String whiteListStatusSource;


	
	public AResMes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getThreeDSServerTransID() {
		return threeDSServerTransID;
	}

//

	public void setThreeDSServerTransID(String threeDSServerTransID) {
		this.threeDSServerTransID = threeDSServerTransID;
	}



	public String getAcsChallengeMandated() {
		return acsChallengeMandated;
	}

	public void setAcsChallengeMandated(String acsChallengeMandated) {
		this.acsChallengeMandated = acsChallengeMandated;
	}

	public String getAcsDecConInd() {
		return acsDecConInd;
	}

	public void setAcsDecConInd(String acsDecConInd) {
		this.acsDecConInd = acsDecConInd;
	}

	public String getAcsOperatorID() {
		return acsOperatorID;
	}

	public void setAcsOperatorID(String acsOperatorID) {
		this.acsOperatorID = acsOperatorID;
	}



	public String getAcsReferenceNumber() {
		return acsReferenceNumber;
	}



	public void setAcsReferenceNumber(String acsReferenceNumber) {
		this.acsReferenceNumber = acsReferenceNumber;
	}



	public Map<String, String> getAcsRenderingType() {
		return acsRenderingType;
	}



	public void setAcsRenderingType(Map<String, String> acsRenderingType) {
		this.acsRenderingType = acsRenderingType;
	}



	public String getAcsSignedContent() {
		return acsSignedContent;
	}



	public void setAcsSignedContent(String acsSignedContent) {
		this.acsSignedContent = acsSignedContent;
	}



	public String getAcsTransID() {
		return acsTransID;
	}



	public void setAcsTransID(String acsTransID) {
		this.acsTransID = acsTransID;
	}



	public String getAcsURL() {
		return acsURL;
	}
	
	public void setAcsURL(String acsURL) {
		this.acsURL = acsURL;
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



	public Map<String, String>  getBroadInfo() {
		return broadInfo;
	}



	public void setBroadInfo(Map<String, String>  broadInfo) {
		this.broadInfo = broadInfo;
	}



	public String getCardholderInfo() {
		return cardholderInfo;
	}



	public void setCardholderInfo(String cardholderInfo) {
		this.cardholderInfo = cardholderInfo;
	}



	public String getDsReferenceNumber() {
		return dsReferenceNumber;
	}



	public void setDsReferenceNumber(String dsReferenceNumber) {
		this.dsReferenceNumber = dsReferenceNumber;
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



	public AResMes(String threeDSServerTransID, String acsChallengeMandated, String acsDecConInd, String acsOperatorID,
			String acsReferenceNumber, Map<String, String> acsRenderingType, String acsSignedContent, String acsTransID,
			String acsURL, String authenticationType, String authenticationValue, Map<String, String>  broadInfo,
			String cardholderInfo, String dsReferenceNumber, String dsTransID, String eci, MessageExtension[] messageExtension,
			String messageType, String messageVersion, String sdkTransID, String transStatus, String transStatusReason,
			String whiteListStatus, String whiteListStatusSource) {
		super();
		this.threeDSServerTransID = threeDSServerTransID;
		this.acsChallengeMandated = acsChallengeMandated;
		this.acsDecConInd = acsDecConInd;
		this.acsOperatorID = acsOperatorID;
		this.acsReferenceNumber = acsReferenceNumber;
		this.acsRenderingType = acsRenderingType;
		this.acsSignedContent = acsSignedContent;
		this.acsTransID = acsTransID;
		this.acsURL = acsURL;
		this.authenticationType = authenticationType;
		this.authenticationValue = authenticationValue;
		this.broadInfo = broadInfo;
		this.cardholderInfo = cardholderInfo;
		this.dsReferenceNumber = dsReferenceNumber;
		this.dsTransID = dsTransID;
		this.eci = eci;
		this.messageExtension = messageExtension;
		this.messageType = messageType;
		this.messageVersion = messageVersion;
		this.sdkTransID = sdkTransID;
		this.transStatus = transStatus;
		this.transStatusReason = transStatusReason;
		this.whiteListStatus = whiteListStatus;
		this.whiteListStatusSource = whiteListStatusSource;
	}



	@Override
	public String toString() {
		return "AResMes [threeDSServerTransID=" + threeDSServerTransID + ", acsChallengeMandated="
				+ acsChallengeMandated + ", acsDecConInd=" + acsDecConInd + ", acsOperatorID=" + acsOperatorID
				+ ", acsReferenceNumber=" + acsReferenceNumber + ", acsRenderingType=" + acsRenderingType
				+ ", acsSignedContent=" + acsSignedContent + ", acsTransID=" + acsTransID + ", acsURL=" + acsURL
				+ ", authenticationType=" + authenticationType + ", authenticationValue=" + authenticationValue
				+ ", broadInfo=" + broadInfo + ", cardholderInfo=" + cardholderInfo + ", dsReferenceNumber="
				+ dsReferenceNumber + ", dsTransID=" + dsTransID + ", eci=" + eci + ", messageExtension="
				+ messageExtension + ", messageType=" + messageType + ", messageVersion=" + messageVersion
				+ ", sdkTransID=" + sdkTransID + ", transStatus=" + transStatus + ", transStatusReason="
				+ transStatusReason + ", whiteListStatus=" + whiteListStatus + ", whiteListStatusSource="
				+ whiteListStatusSource + "]";
	}
	
	
	
	
}
