package acs.message;

public class CResMes {

	private String threeDSServerTransID;
	private String acsCounterAtoS;
	private String acsTransID;

	private String acsHTML;
	private String acsUiType;

	private String challengeCompletionInd;

	private String challengeInfoHeader;
	private String challengeInfoLabel;
	private String challengeInfoText;

	private String challengeInfoTextIndicator;
	private String challengeSelectInfo;
	private String expandInfoLabel;

	private String expandInfoText;
	private String issuerImage;
	private String oobAppURL;

	private String oobAppLabel;
	private String oobContinueLabel;
	private String psImage;
	private String resendInformationLabel;

	private MessageExtension[] messageExtension;
	private String messageType;
	private String messageVersion;
	private String sdkTransID;

	private String submitAuthenticationLabel;
	private String whitelistingInfoText;
	private String whyInfoLabel;
	private String whyInfoText;
	
	
	
	
	public CResMes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CResMes(String threeDSServerTransID, String acsCounterAtoS, String acsTransID, String acsHTML,
			String acsUiType, String challengeCompletionInd, String challengeInfoHeader, String challengeInfoLabel,
			String challengeInfoText, String challengeInfoTextIndicator, String challengeSelectInfo,
			String expandInfoLabel, String expandInfoText, String issuerImage, String oobAppURL, String oobAppLabel,
			String oobContinueLabel, String psImage, String resendInformationLabel, MessageExtension[] messageExtension,
			String messageType, String messageVersion, String sdkTransID, String submitAuthenticationLabel,
			String whitelistingInfoText, String whyInfoLabel, String whyInfoText) {
		super();
		this.threeDSServerTransID = threeDSServerTransID;
		this.acsCounterAtoS = acsCounterAtoS;
		this.acsTransID = acsTransID;
		this.acsHTML = acsHTML;
		this.acsUiType = acsUiType;
		this.challengeCompletionInd = challengeCompletionInd;
		this.challengeInfoHeader = challengeInfoHeader;
		this.challengeInfoLabel = challengeInfoLabel;
		this.challengeInfoText = challengeInfoText;
		this.challengeInfoTextIndicator = challengeInfoTextIndicator;
		this.challengeSelectInfo = challengeSelectInfo;
		this.expandInfoLabel = expandInfoLabel;
		this.expandInfoText = expandInfoText;
		this.issuerImage = issuerImage;
		this.oobAppURL = oobAppURL;
		this.oobAppLabel = oobAppLabel;
		this.oobContinueLabel = oobContinueLabel;
		this.psImage = psImage;
		this.resendInformationLabel = resendInformationLabel;
		this.messageExtension = messageExtension;
		this.messageType = messageType;
		this.messageVersion = messageVersion;
		this.sdkTransID = sdkTransID;
		this.submitAuthenticationLabel = submitAuthenticationLabel;
		this.whitelistingInfoText = whitelistingInfoText;
		this.whyInfoLabel = whyInfoLabel;
		this.whyInfoText = whyInfoText;
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
	public String getAcsHTML() {
		return acsHTML;
	}
	public void setAcsHTML(String acsHTML) {
		this.acsHTML = acsHTML;
	}
	public String getAcsUiType() {
		return acsUiType;
	}
	public void setAcsUiType(String acsUiType) {
		this.acsUiType = acsUiType;
	}
	public String getChallengeCompletionInd() {
		return challengeCompletionInd;
	}
	public void setChallengeCompletionInd(String challengeCompletionInd) {
		this.challengeCompletionInd = challengeCompletionInd;
	}
	public String getChallengeInfoHeader() {
		return challengeInfoHeader;
	}
	public void setChallengeInfoHeader(String challengeInfoHeader) {
		this.challengeInfoHeader = challengeInfoHeader;
	}
	public String getChallengeInfoLabel() {
		return challengeInfoLabel;
	}
	public void setChallengeInfoLabel(String challengeInfoLabel) {
		this.challengeInfoLabel = challengeInfoLabel;
	}
	public String getChallengeInfoText() {
		return challengeInfoText;
	}
	public void setChallengeInfoText(String challengeInfoText) {
		this.challengeInfoText = challengeInfoText;
	}
	public String getChallengeInfoTextIndicator() {
		return challengeInfoTextIndicator;
	}
	public void setChallengeInfoTextIndicator(String challengeInfoTextIndicator) {
		this.challengeInfoTextIndicator = challengeInfoTextIndicator;
	}
	public String getChallengeSelectInfo() {
		return challengeSelectInfo;
	}
	public void setChallengeSelectInfo(String challengeSelectInfo) {
		this.challengeSelectInfo = challengeSelectInfo;
	}
	public String getExpandInfoLabel() {
		return expandInfoLabel;
	}
	public void setExpandInfoLabel(String expandInfoLabel) {
		this.expandInfoLabel = expandInfoLabel;
	}
	public String getExpandInfoText() {
		return expandInfoText;
	}
	public void setExpandInfoText(String expandInfoText) {
		this.expandInfoText = expandInfoText;
	}
	public String getIssuerImage() {
		return issuerImage;
	}
	public void setIssuerImage(String issuerImage) {
		this.issuerImage = issuerImage;
	}
	public String getOobAppURL() {
		return oobAppURL;
	}
	public void setOobAppURL(String oobAppURL) {
		this.oobAppURL = oobAppURL;
	}
	public String getOobAppLabel() {
		return oobAppLabel;
	}
	public void setOobAppLabel(String oobAppLabel) {
		this.oobAppLabel = oobAppLabel;
	}
	public String getOobContinueLabel() {
		return oobContinueLabel;
	}
	public void setOobContinueLabel(String oobContinueLabel) {
		this.oobContinueLabel = oobContinueLabel;
	}
	public String getPsImage() {
		return psImage;
	}
	public void setPsImage(String psImage) {
		this.psImage = psImage;
	}
	public String getResendInformationLabel() {
		return resendInformationLabel;
	}
	public void setResendInformationLabel(String resendInformationLabel) {
		this.resendInformationLabel = resendInformationLabel;
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
