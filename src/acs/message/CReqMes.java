package acs.message;

/*
 *  challenge
 *  3DS --> ACS
 */
public class CReqMes {
	private String threeDSRequestorAppURL;
	private String threeDSServerTransID;
	private String acsTransID;
	private String challengeCancel;
	private String challengeDataEntry;
	private String challengeHTMLDataEntry;
	private String challengeNoEntry;
	private String challengeWindowSize;
	private String messageExtension;
	private String messageType;
	private String messageVersion;
	private String oobContinue;
	private String sdkTransID;
	private String sdkCounterStoA;
	private String whitelistingDataEntry;
	private String submitAuthenticationLabel;
	private String whitelistingInfoText;
	private String whyInfoLabel;
	private String whyInfoText;
	
	
	
	public CReqMes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CReqMes(String threeDSRequestorAppURL, String threeDSServerTransID, String acsTransID,
			String challengeCancel, String challengeDataEntry, String challengeHTMLDataEntry, String challengeNoEntry,
			String challengeWindowSize, String messageExtension, String messageType, String messageVersion,
			String oobContinue, String sdkTransID, String sdkCounterStoA, String whitelistingDataEntry,
			String submitAuthenticationLabel, String whitelistingInfoText, String whyInfoLabel, String whyInfoText) {
		super();
		this.threeDSRequestorAppURL = threeDSRequestorAppURL;
		this.threeDSServerTransID = threeDSServerTransID;
		this.acsTransID = acsTransID;
		this.challengeCancel = challengeCancel;
		this.challengeDataEntry = challengeDataEntry;
		this.challengeHTMLDataEntry = challengeHTMLDataEntry;
		this.challengeNoEntry = challengeNoEntry;
		this.challengeWindowSize = challengeWindowSize;
		this.messageExtension = messageExtension;
		this.messageType = messageType;
		this.messageVersion = messageVersion;
		this.oobContinue = oobContinue;
		this.sdkTransID = sdkTransID;
		this.sdkCounterStoA = sdkCounterStoA;
		this.whitelistingDataEntry = whitelistingDataEntry;
		this.submitAuthenticationLabel = submitAuthenticationLabel;
		this.whitelistingInfoText = whitelistingInfoText;
		this.whyInfoLabel = whyInfoLabel;
		this.whyInfoText = whyInfoText;
	}
	public String getThreeDSRequestorAppURL() {
		return threeDSRequestorAppURL;
	}
	public void setThreeDSRequestorAppURL(String threeDSRequestorAppURL) {
		this.threeDSRequestorAppURL = threeDSRequestorAppURL;
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
	public String getChallengeCancel() {
		return challengeCancel;
	}
	public void setChallengeCancel(String challengeCancel) {
		this.challengeCancel = challengeCancel;
	}
	public String getChallengeDataEntry() {
		return challengeDataEntry;
	}
	public void setChallengeDataEntry(String challengeDataEntry) {
		this.challengeDataEntry = challengeDataEntry;
	}
	public String getChallengeHTMLDataEntry() {
		return challengeHTMLDataEntry;
	}
	public void setChallengeHTMLDataEntry(String challengeHTMLDataEntry) {
		this.challengeHTMLDataEntry = challengeHTMLDataEntry;
	}
	public String getChallengeNoEntry() {
		return challengeNoEntry;
	}
	public void setChallengeNoEntry(String challengeNoEntry) {
		this.challengeNoEntry = challengeNoEntry;
	}
	public String getChallengeWindowSize() {
		return challengeWindowSize;
	}
	public void setChallengeWindowSize(String challengeWindowSize) {
		this.challengeWindowSize = challengeWindowSize;
	}
	public String getMessageExtension() {
		return messageExtension;
	}
	public void setMessageExtension(String messageExtension) {
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
	public String getOobContinue() {
		return oobContinue;
	}
	public void setOobContinue(String oobContinue) {
		this.oobContinue = oobContinue;
	}
	public String getSdkTransID() {
		return sdkTransID;
	}
	public void setSdkTransID(String sdkTransID) {
		this.sdkTransID = sdkTransID;
	}
	public String getSdkCounterStoA() {
		return sdkCounterStoA;
	}
	public void setSdkCounterStoA(String sdkCounterStoA) {
		this.sdkCounterStoA = sdkCounterStoA;
	}
	public String getWhitelistingDataEntry() {
		return whitelistingDataEntry;
	}
	public void setWhitelistingDataEntry(String whitelistingDataEntry) {
		this.whitelistingDataEntry = whitelistingDataEntry;
	}
	public String getSubmitAuthenticationLabel() {
		return submitAuthenticationLabel;
	}
	public void setSubmitAuthenticationLabel(String submitAuthenticationLabel) {
		this.submitAuthenticationLabel = submitAuthenticationLabel;
	}
	public String getWhitelistingInfoText() {
		return whitelistingInfoText;
	}
	public void setWhitelistingInfoText(String whitelistingInfoText) {
		this.whitelistingInfoText = whitelistingInfoText;
	}
	public String getWhyInfoLabel() {
		return whyInfoLabel;
	}
	public void setWhyInfoLabel(String whyInfoLabel) {
		this.whyInfoLabel = whyInfoLabel;
	}
	public String getWhyInfoText() {
		return whyInfoText;
	}
	public void setWhyInfoText(String whyInfoText) {
		this.whyInfoText = whyInfoText;
	}
	
	
	
}
