
package acs.message;

import java.util.Map;

import acs.message.detailMsg.AcsRenderingType;
import acs.message.detailMsg.DeviceRenderOptions;
import acs.message.riskIndicator.AcctInfo;
import acs.message.riskIndicator.MerchantRiskIndicator;
import acs.message.riskIndicator.ThreeDSRequestorAuthenticationInfo;
import acs.message.riskIndicator.ThreeDSRequestorPriorAuthenticationInfo;

/*
 * 3DS ---> ACS
 */
public class AReqMes {

	private String threeDSRequestorURL;
	private String threeDSCompInd; // 1 - Y -N - U 
	private String threeDSRequestorAuthenticationInd; 
	private ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo;
	private String threeDSReqAuthMethodInd;
	private String threeDSRequestorChallengeInd;
	private String threeDSRequestorDecMaxTime;
	private String threeDSRequestorDecReqInd;
	private String threeDSRequestorID;
	private String threeDSRequestorName;
	private ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo;
	private String threeDSServerRefNumber;
	private String threeDSServerOperatorID;
	private String threeDSServerTransID;
	private String threeDSServerURL;
	private String threeRIInd;
	private String acctType;
	private Map<String, String> mobilePhone;
	private String cardholderName;
	private String shipAddrCity;
	private String shipAddrCountry;
	private String shipAddrLine1;
	private String shipAddrLine2;
	private String shipAddrLine3;
	private String shipAddrPostCode;
	private String shipAddrState;
	private Map<String, String> workPhone ;
	private String deviceChannel ;
	private String deviceInfo;
	private DeviceRenderOptions deviceRenderOptions;
	private String dsReferenceNumber;
	private String dsTransID;
	private String dsURL; // use to send the RReqMes to the DS
	private Boolean payTokenInd;
	private String payTokenSource;
	private String purchaseInstalData;
	private String mcc;
	private String merchantCountryCode;
	private String merchantName;
	private MerchantRiskIndicator merchantRiskIndicator;
	private String messageCategory;
	private MessageExtension[] messageExtension;
	private String messageType;
	private String messageVersion;
	private String acsReferenceNumber;
	private AcsRenderingType acsRenderingType;
	private String  acsSignedContent;
	private String acsTransID;
	private String authenticationType;
	private String authenticationValue;
	private Map<String, String>  broadInfo;
	private String cardholderInfo;
	private String eci;
	private String sdkTransID;
	private String transStatus;
	public String transStatusReason;
	public String whiteListStatus;
	public String whiteListStatusSource;
	public String acquirerBIN;
	public String acquirerMerchantID;
	public String addrMatch;
	public String browserAcceptHeader;
	public String browserIP;
	public Boolean browserJavaEnabled;
	public String browserJavascriptEnabled;
	public String browserLanguage;
	public String browserColorDepth;
	public String browserScreenHeight;
	public String browserScreenWidth;
	public String browserTZ;
	public String browserUserAgent;
	public String cardExpiryDate;
	public AcctInfo acctInfo;
	public String acctNumber;
	public String acctID;
	public String billAddrCity;
	public String billAddrCountry;
	public String billAddrLine1;
	public String billAddrLine2;
	public String billAddrLine3;
	public String billAddrPostCode;
	public String billAddrState;
	public String email;
	public Map<String, String> homePhone;
	public String notificationURL; // use to send the CRes 
	public String purchaseAmount;
	public String purchaseCurrency;
	public String purchaseExponent;
	public String purchaseDate;
	public String recurringExpiry;
	public String recurringFrequency;
	public String sdkAppID;
	public String sdkEncData;
	public Map<String, String> sdkEphemPubKey;
	public String sdkMaxTimeout;
	public String sdkReferenceNumber;
	public String transType;

	public AReqMes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AReqMes(String threeDSRequestorURL, String threeDSCompInd, String threeDSRequestorAuthenticationInd,
			ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo, String threeDSReqAuthMethodInd,
			String threeDSRequestorChallengeInd, String threeDSRequestorDecMaxTime, String threeDSRequestorDecReqInd,
			String threeDSRequestorID, String threeDSRequestorName,
			ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo, String threeDSServerRefNumber,
			String threeDSServerOperatorID, String threeDSServerTransID, String threeDSServerURL, String threeRIInd,
			String acctType, Map<String, String> mobilePhone, String cardholderName, String shipAddrCity,
			String shipAddrCountry, String shipAddrLine1, String shipAddrLine2, String shipAddrLine3,
			String shipAddrPostCode, String shipAddrState, Map<String, String> workPhone, String deviceChannel,
			String deviceInfo, DeviceRenderOptions deviceRenderOptions, String dsReferenceNumber, String dsTransID, String dsURL,
			Boolean payTokenInd, String payTokenSource, String purchaseInstalData, String mcc,
			String merchantCountryCode, String merchantName, MerchantRiskIndicator merchantRiskIndicator,
			String messageCategory, MessageExtension [] messageExtension, String messageType, String messageVersion,
			String acsReferenceNumber, AcsRenderingType acsRenderingType, String acsSignedContent, String acsTransID,
		    String authenticationType, String authenticationValue, Map<String, String> broadInfo,
			String cardholderInfo, String eci, String sdkTransID, String transStatus, String transStatusReason,
			String whiteListStatus, String whiteListStatusSource, String acquirerBIN, String acquirerMerchantID,
			String addrMatch, String browserAcceptHeader, String browserIP, Boolean browserJavaEnabled,
			String browserJavascriptEnabled, String browserLanguage, String browserColorDepth,
			String browserScreenHeight, String browserScreenWidth, String browserTZ, String browserUserAgent,
			String cardExpiryDate, AcctInfo acctInfo, String acctNumber, String acctID, String billAddrCity,
			String billAddrCountry, String billAddrLine1, String billAddrLine2, String billAddrLine3,
			String billAddrPostCode, String billAddrState, String email, Map<String, String> homePhone,
			String notificationURL, String purchaseAmount, String purchaseCurrency, String purchaseExponent,
			String purchaseDate, String recurringExpiry, String recurringFrequency, String sdkAppID, String sdkEncData,
			Map<String, String> sdkEphemPubKey, String sdkMaxTimeout, String sdkReferenceNumber, String transType) {
		super();
		this.threeDSRequestorURL = threeDSRequestorURL;
		this.threeDSCompInd = threeDSCompInd;
		this.threeDSRequestorAuthenticationInd = threeDSRequestorAuthenticationInd;
		this.threeDSRequestorAuthenticationInfo = threeDSRequestorAuthenticationInfo;
		this.threeDSReqAuthMethodInd = threeDSReqAuthMethodInd;
		this.threeDSRequestorChallengeInd = threeDSRequestorChallengeInd;
		this.threeDSRequestorDecMaxTime = threeDSRequestorDecMaxTime;
		this.threeDSRequestorDecReqInd = threeDSRequestorDecReqInd;
		this.threeDSRequestorID = threeDSRequestorID;
		this.threeDSRequestorName = threeDSRequestorName;
		this.threeDSRequestorPriorAuthenticationInfo = threeDSRequestorPriorAuthenticationInfo;
		this.threeDSServerRefNumber = threeDSServerRefNumber;
		this.threeDSServerOperatorID = threeDSServerOperatorID;
		this.threeDSServerTransID = threeDSServerTransID;
		this.threeDSServerURL = threeDSServerURL;
		this.threeRIInd = threeRIInd;
		this.acctType = acctType;
		this.mobilePhone = mobilePhone;
		this.cardholderName = cardholderName;
		this.shipAddrCity = shipAddrCity;
		this.shipAddrCountry = shipAddrCountry;
		this.shipAddrLine1 = shipAddrLine1;
		this.shipAddrLine2 = shipAddrLine2;
		this.shipAddrLine3 = shipAddrLine3;
		this.shipAddrPostCode = shipAddrPostCode;
		this.shipAddrState = shipAddrState;
		this.workPhone = workPhone;
		this.deviceChannel = deviceChannel;
		this.deviceInfo = deviceInfo;
		this.deviceRenderOptions = deviceRenderOptions;
		this.dsReferenceNumber = dsReferenceNumber;
		this.dsTransID = dsTransID;
		this.dsURL = dsURL;
		this.payTokenInd = payTokenInd;
		this.payTokenSource = payTokenSource;
		this.purchaseInstalData = purchaseInstalData;
		this.mcc = mcc;
		this.merchantCountryCode = merchantCountryCode;
		this.merchantName = merchantName;
		this.merchantRiskIndicator = merchantRiskIndicator;
		this.messageCategory = messageCategory;
		this.messageExtension = messageExtension;
		this.messageType = messageType;
		this.messageVersion = messageVersion;
		this.acsReferenceNumber = acsReferenceNumber;
		this.acsRenderingType = acsRenderingType;
		this.acsSignedContent = acsSignedContent;
		this.acsTransID = acsTransID;
		this.authenticationType = authenticationType;
		this.authenticationValue = authenticationValue;
		this.broadInfo = broadInfo;
		this.cardholderInfo = cardholderInfo;
		this.eci = eci;
		this.sdkTransID = sdkTransID;
		this.transStatus = transStatus;
		this.transStatusReason = transStatusReason;
		this.whiteListStatus = whiteListStatus;
		this.whiteListStatusSource = whiteListStatusSource;
		this.acquirerBIN = acquirerBIN;
		this.acquirerMerchantID = acquirerMerchantID;
		this.addrMatch = addrMatch;
		this.browserAcceptHeader = browserAcceptHeader;
		this.browserIP = browserIP;
		this.browserJavaEnabled = browserJavaEnabled;
		this.browserJavascriptEnabled = browserJavascriptEnabled;
		this.browserLanguage = browserLanguage;
		this.browserColorDepth = browserColorDepth;
		this.browserScreenHeight = browserScreenHeight;
		this.browserScreenWidth = browserScreenWidth;
		this.browserTZ = browserTZ;
		this.browserUserAgent = browserUserAgent;
		this.cardExpiryDate = cardExpiryDate;
		this.acctInfo = acctInfo;
		this.acctNumber = acctNumber;
		this.acctID = acctID;
		this.billAddrCity = billAddrCity;
		this.billAddrCountry = billAddrCountry;
		this.billAddrLine1 = billAddrLine1;
		this.billAddrLine2 = billAddrLine2;
		this.billAddrLine3 = billAddrLine3;
		this.billAddrPostCode = billAddrPostCode;
		this.billAddrState = billAddrState;
		this.email = email;
		this.homePhone = homePhone;
		this.notificationURL = notificationURL;
		this.purchaseAmount = purchaseAmount;
		this.purchaseCurrency = purchaseCurrency;
		this.purchaseExponent = purchaseExponent;
		this.purchaseDate = purchaseDate;
		this.recurringExpiry = recurringExpiry;
		this.recurringFrequency = recurringFrequency;
		this.sdkAppID = sdkAppID;
		this.sdkEncData = sdkEncData;
		this.sdkEphemPubKey = sdkEphemPubKey;
		this.sdkMaxTimeout = sdkMaxTimeout;
		this.sdkReferenceNumber = sdkReferenceNumber;
		this.transType = transType;
	}




	public String getThreeDSRequestorURL() {
		return threeDSRequestorURL;
	}

	public void setThreeDSRequestorURL(String threeDSRequestorURL) {
		this.threeDSRequestorURL = threeDSRequestorURL;
	}

	public String getThreeDSCompInd() {
		return threeDSCompInd;
	}


	public void setThreeDSCompInd(String threeDSCompInd) {
		this.threeDSCompInd = threeDSCompInd;
	}


	public String getThreeDSRequestorAuthenticationInd() {
		return threeDSRequestorAuthenticationInd;
	}

	public void setThreeDSRequestorAuthenticationInd(String threeDSRequestorAuthenticationInd) {
		this.threeDSRequestorAuthenticationInd = threeDSRequestorAuthenticationInd;
	}




	public ThreeDSRequestorAuthenticationInfo getThreeDSRequestorAuthenticationInfo() {
		return threeDSRequestorAuthenticationInfo;
	}




	public void setThreeDSRequestorAuthenticationInfo(ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo) {
		this.threeDSRequestorAuthenticationInfo = threeDSRequestorAuthenticationInfo;
	}




	public String getThreeDSReqAuthMethodInd() {
		return threeDSReqAuthMethodInd;
	}




	public void setThreeDSReqAuthMethodInd(String threeDSReqAuthMethodInd) {
		this.threeDSReqAuthMethodInd = threeDSReqAuthMethodInd;
	}




	public String getThreeDSRequestorChallengeInd() {
		return threeDSRequestorChallengeInd;
	}




	public void setThreeDSRequestorChallengeInd(String threeDSRequestorChallengeInd) {
		this.threeDSRequestorChallengeInd = threeDSRequestorChallengeInd;
	}




	public String getThreeDSRequestorDecMaxTime() {
		return threeDSRequestorDecMaxTime;
	}




	public void setThreeDSRequestorDecMaxTime(String threeDSRequestorDecMaxTime) {
		this.threeDSRequestorDecMaxTime = threeDSRequestorDecMaxTime;
	}




	public String getThreeDSRequestorDecReqInd() {
		return threeDSRequestorDecReqInd;
	}


	public void setThreeDSRequestorDecReqInd(String threeDSRequestorDecReqInd) {
		this.threeDSRequestorDecReqInd = threeDSRequestorDecReqInd;
	}

	public String getThreeDSRequestorID() {
		return threeDSRequestorID;
	}

	public void setThreeDSRequestorID(String threeDSRequestorID) {
		this.threeDSRequestorID = threeDSRequestorID;
	}

	public String getThreeDSRequestorName() {
		return threeDSRequestorName;
	}

	public void setThreeDSRequestorName(String threeDSRequestorName) {
		this.threeDSRequestorName = threeDSRequestorName;
	}

	public ThreeDSRequestorPriorAuthenticationInfo getThreeDSRequestorPriorAuthenticationInfo() {
		return threeDSRequestorPriorAuthenticationInfo;
	}




	public void setThreeDSRequestorPriorAuthenticationInfo(ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo) {
		this.threeDSRequestorPriorAuthenticationInfo = threeDSRequestorPriorAuthenticationInfo;
	}




	public String getThreeDSServerRefNumber() {
		return threeDSServerRefNumber;
	}




	public void setThreeDSServerRefNumber(String threeDSServerRefNumber) {
		this.threeDSServerRefNumber = threeDSServerRefNumber;
	}




	public String getThreeDSServerOperatorID() {
		return threeDSServerOperatorID;
	}




	public void setThreeDSServerOperatorID(String threeDSServerOperatorID) {
		this.threeDSServerOperatorID = threeDSServerOperatorID;
	}




	public String getThreeDSServerTransID() {
		return threeDSServerTransID;
	}




	public void setThreeDSServerTransID(String threeDSServerTransID) {
		this.threeDSServerTransID = threeDSServerTransID;
	}




	public String getThreeDSServerURL() {
		return threeDSServerURL;
	}




	public void setThreeDSServerURL(String threeDSServerURL) {
		this.threeDSServerURL = threeDSServerURL;
	}




	public String getThreeRIInd() {
		return threeRIInd;
	}




	public void setThreeRIInd(String threeRIInd) {
		this.threeRIInd = threeRIInd;
	}




	public String getAcctType() {
		return acctType;
	}




	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}




	public Map<String, String> getMobilePhone() {
		return mobilePhone;
	}




	public void setMobilePhone(Map<String, String> mobilePhone) {
		this.mobilePhone = mobilePhone;
	}




	public String getCardholderName() {
		return cardholderName;
	}




	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}




	public String getShipAddrCity() {
		return shipAddrCity;
	}




	public void setShipAddrCity(String shipAddrCity) {
		this.shipAddrCity = shipAddrCity;
	}




	public String getShipAddrCountry() {
		return shipAddrCountry;
	}




	public void setShipAddrCountry(String shipAddrCountry) {
		this.shipAddrCountry = shipAddrCountry;
	}




	public String getShipAddrLine1() {
		return shipAddrLine1;
	}




	public void setShipAddrLine1(String shipAddrLine1) {
		this.shipAddrLine1 = shipAddrLine1;
	}




	public String getShipAddrLine2() {
		return shipAddrLine2;
	}




	public void setShipAddrLine2(String shipAddrLine2) {
		this.shipAddrLine2 = shipAddrLine2;
	}




	public String getShipAddrLine3() {
		return shipAddrLine3;
	}




	public void setShipAddrLine3(String shipAddrLine3) {
		this.shipAddrLine3 = shipAddrLine3;
	}




	public String getShipAddrPostCode() {
		return shipAddrPostCode;
	}




	public void setShipAddrPostCode(String shipAddrPostCode) {
		this.shipAddrPostCode = shipAddrPostCode;
	}




	public String getShipAddrState() {
		return shipAddrState;
	}




	public void setShipAddrState(String shipAddrState) {
		this.shipAddrState = shipAddrState;
	}




	public Map<String, String> getWorkPhone() {
		return workPhone;
	}




	public void setWorkPhone(Map<String, String> workPhone) {
		this.workPhone = workPhone;
	}




	public String getDeviceChannel() {
		return deviceChannel;
	}




	public void setDeviceChannel(String deviceChannel) {
		this.deviceChannel = deviceChannel;
	}




	public String getDeviceInfo() {
		return deviceInfo;
	}




	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}




	public DeviceRenderOptions getDeviceRenderOptions() {
		return deviceRenderOptions;
	}




	public void setDeviceRenderOptions(DeviceRenderOptions deviceRenderOptions) {
		this.deviceRenderOptions = deviceRenderOptions;
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

	public String getDsURL() {
		return dsURL;
	}


	public void setDsURL(String dsURL) {
		this.dsURL = dsURL;
	}

	public Boolean getPayTokenInd() {
		return payTokenInd;
	}

	public void setPayTokenInd(Boolean payTokenInd) {
		this.payTokenInd = payTokenInd;
	}

	public String getPayTokenSource() {
		return payTokenSource;
	}

	public void setPayTokenSource(String payTokenSource) {
		this.payTokenSource = payTokenSource;
	}

	public String getPurchaseInstalData() {
		return purchaseInstalData;
	}

	public void setPurchaseInstalData(String purchaseInstalData) {
		this.purchaseInstalData = purchaseInstalData;
	}
	
	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMerchantCountryCode() {
		return merchantCountryCode;
	}

	public void setMerchantCountryCode(String merchantCountryCode) {
		this.merchantCountryCode = merchantCountryCode;
	}

	public String getMerchantName() {
		return merchantName;
	}




	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}




	public MerchantRiskIndicator getMerchantRiskIndicator() {
		return merchantRiskIndicator;
	}




	public void setMerchantRiskIndicator(MerchantRiskIndicator merchantRiskIndicator) {
		this.merchantRiskIndicator = merchantRiskIndicator;
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




	public String getAcsReferenceNumber() {
		return acsReferenceNumber;
	}




	public void setAcsReferenceNumber(String acsReferenceNumber) {
		this.acsReferenceNumber = acsReferenceNumber;
	}




	public AcsRenderingType getAcsRenderingType() {
		return acsRenderingType;
	}




	public void setAcsRenderingType(AcsRenderingType acsRenderingType) {
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




	public Map<String, String> getBroadInfo() {
		return broadInfo;
	}




	public void setBroadInfo(Map<String, String> broadInfo) {
		this.broadInfo = broadInfo;
	}




	public String getCardholderInfo() {
		return cardholderInfo;
	}




	public void setCardholderInfo(String cardholderInfo) {
		this.cardholderInfo = cardholderInfo;
	}




	public String getEci() {
		return eci;
	}




	public void setEci(String eci) {
		this.eci = eci;
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




	public String getAcquirerBIN() {
		return acquirerBIN;
	}




	public void setAcquirerBIN(String acquirerBIN) {
		this.acquirerBIN = acquirerBIN;
	}




	public String getAcquirerMerchantID() {
		return acquirerMerchantID;
	}




	public void setAcquirerMerchantID(String acquirerMerchantID) {
		this.acquirerMerchantID = acquirerMerchantID;
	}




	public String getAddrMatch() {
		return addrMatch;
	}




	public void setAddrMatch(String addrMatch) {
		this.addrMatch = addrMatch;
	}




	public String getBrowserAcceptHeader() {
		return browserAcceptHeader;
	}




	public void setBrowserAcceptHeader(String browserAcceptHeader) {
		this.browserAcceptHeader = browserAcceptHeader;
	}




	public String getBrowserIP() {
		return browserIP;
	}




	public void setBrowserIP(String browserIP) {
		this.browserIP = browserIP;
	}




	public Boolean getBrowserJavaEnabled() {
		return browserJavaEnabled;
	}




	public void setBrowserJavaEnabled(Boolean browserJavaEnabled) {
		this.browserJavaEnabled = browserJavaEnabled;
	}




	public String getBrowserJavascriptEnabled() {
		return browserJavascriptEnabled;
	}




	public void setBrowserJavascriptEnabled(String browserJavascriptEnabled) {
		this.browserJavascriptEnabled = browserJavascriptEnabled;
	}




	public String getBrowserLanguage() {
		return browserLanguage;
	}




	public void setBrowserLanguage(String browserLanguage) {
		this.browserLanguage = browserLanguage;
	}




	public String getBrowserColorDepth() {
		return browserColorDepth;
	}




	public void setBrowserColorDepth(String browserColorDepth) {
		this.browserColorDepth = browserColorDepth;
	}




	public String getBrowserScreenHeight() {
		return browserScreenHeight;
	}




	public void setBrowserScreenHeight(String browserScreenHeight) {
		this.browserScreenHeight = browserScreenHeight;
	}




	public String getBrowserScreenWidth() {
		return browserScreenWidth;
	}




	public void setBrowserScreenWidth(String browserScreenWidth) {
		this.browserScreenWidth = browserScreenWidth;
	}




	public String getBrowserTZ() {
		return browserTZ;
	}




	public void setBrowserTZ(String browserTZ) {
		this.browserTZ = browserTZ;
	}




	public String getBrowserUserAgent() {
		return browserUserAgent;
	}




	public void setBrowserUserAgent(String browserUserAgent) {
		this.browserUserAgent = browserUserAgent;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public AcctInfo getAcctInfo() {
		return acctInfo;
	}

	public void setAcctInfo(AcctInfo acctInfo) {
		this.acctInfo = acctInfo;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getAcctID() {
		return acctID;
	}

	public void setAcctID(String acctID) {
		this.acctID = acctID;
	}

	public String getBillAddrCity() {
		return billAddrCity;
	}




	public void setBillAddrCity(String billAddrCity) {
		this.billAddrCity = billAddrCity;
	}




	public String getBillAddrCountry() {
		return billAddrCountry;
	}




	public void setBillAddrCountry(String billAddrCountry) {
		this.billAddrCountry = billAddrCountry;
	}




	public String getBillAddrLine1() {
		return billAddrLine1;
	}




	public void setBillAddrLine1(String billAddrLine1) {
		this.billAddrLine1 = billAddrLine1;
	}




	public String getBillAddrLine2() {
		return billAddrLine2;
	}




	public void setBillAddrLine2(String billAddrLine2) {
		this.billAddrLine2 = billAddrLine2;
	}




	public String getBillAddrLine3() {
		return billAddrLine3;
	}




	public void setBillAddrLine3(String billAddrLine3) {
		this.billAddrLine3 = billAddrLine3;
	}




	public String getBillAddrPostCode() {
		return billAddrPostCode;
	}




	public void setBillAddrPostCode(String billAddrPostCode) {
		this.billAddrPostCode = billAddrPostCode;
	}




	public String getBillAddrState() {
		return billAddrState;
	}




	public void setBillAddrState(String billAddrState) {
		this.billAddrState = billAddrState;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Map<String, String> getHomePhone() {
		return homePhone;
	}




	public void setHomePhone(Map<String, String> homePhone) {
		this.homePhone = homePhone;
	}




	public String getNotificationURL() {
		return notificationURL;
	}




	public void setNotificationURL(String notificationURL) {
		this.notificationURL = notificationURL;
	}




	public String getPurchaseAmount() {
		return purchaseAmount;
	}




	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}




	public String getPurchaseCurrency() {
		return purchaseCurrency;
	}




	public void setPurchaseCurrency(String purchaseCurrency) {
		this.purchaseCurrency = purchaseCurrency;
	}




	public String getPurchaseExponent() {
		return purchaseExponent;
	}




	public void setPurchaseExponent(String purchaseExponent) {
		this.purchaseExponent = purchaseExponent;
	}




	public String getPurchaseDate() {
		return purchaseDate;
	}




	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public String getRecurringExpiry() {
		return recurringExpiry;
	}

	public void setRecurringExpiry(String recurringExpiry) {
		this.recurringExpiry = recurringExpiry;
	}

	public String getRecurringFrequency() {
		return recurringFrequency;
	}

	public void setRecurringFrequency(String recurringFrequency) {
		this.recurringFrequency = recurringFrequency;
	}

	public String getSdkAppID() {
		return sdkAppID;
	}


	public void setSdkAppID(String sdkAppID) {
		this.sdkAppID = sdkAppID;
	}


	public String getSdkEncData() {
		return sdkEncData;
	}


	public void setSdkEncData(String sdkEncData) {
		this.sdkEncData = sdkEncData;
	}




	public Map<String, String> getSdkEphemPubKey() {
		return sdkEphemPubKey;
	}




	public void setSdkEphemPubKey(Map<String, String> sdkEphemPubKey) {
		this.sdkEphemPubKey = sdkEphemPubKey;
	}




	public String getSdkMaxTimeout() {
		return sdkMaxTimeout;
	}




	public void setSdkMaxTimeout(String sdkMaxTimeout) {
		this.sdkMaxTimeout = sdkMaxTimeout;
	}




	public String getSdkReferenceNumber() {
		return sdkReferenceNumber;
	}




	public void setSdkReferenceNumber(String sdkReferenceNumber) {
		this.sdkReferenceNumber = sdkReferenceNumber;
	}




	public String getTransType() {
		return transType;
	}




	public void setTransType(String transType) {
		this.transType = transType;
	}




	@Override
	public String toString() {
		return "AReqMes [threeDSRequestorURL=" + threeDSRequestorURL + ", threeDSCompInd=" + threeDSCompInd
				+ ", threeDSRequestorAuthenticationInd=" + threeDSRequestorAuthenticationInd
				+ ", threeDSRequestorAuthenticationInfo=" + threeDSRequestorAuthenticationInfo
				+ ", threeDSReqAuthMethodInd=" + threeDSReqAuthMethodInd + ", threeDSRequestorChallengeInd="
				+ threeDSRequestorChallengeInd + ", threeDSRequestorDecMaxTime=" + threeDSRequestorDecMaxTime
				+ ", threeDSRequestorDecReqInd=" + threeDSRequestorDecReqInd + ", threeDSRequestorID="
				+ threeDSRequestorID + ", threeDSRequestorName=" + threeDSRequestorName
				+ ", threeDSRequestorPriorAuthenticationInfo=" + threeDSRequestorPriorAuthenticationInfo
				+ ", threeDSServerRefNumber=" + threeDSServerRefNumber + ", threeDSServerOperatorID="
				+ threeDSServerOperatorID + ", threeDSServerTransID=" + threeDSServerTransID + ", threeDSServerURL="
				+ threeDSServerURL + ", threeRIInd=" + threeRIInd + ", acctType=" + acctType + ", mobilePhone="
				+ mobilePhone + ", cardholderName=" + cardholderName + ", shipAddrCity=" + shipAddrCity
				+ ", shipAddrCountry=" + shipAddrCountry + ", shipAddrLine1=" + shipAddrLine1 + ", shipAddrLine2="
				+ shipAddrLine2 + ", shipAddrLine3=" + shipAddrLine3 + ", shipAddrPostCode=" + shipAddrPostCode
				+ ", shipAddrState=" + shipAddrState + ", workPhone=" + workPhone + ", deviceChannel=" + deviceChannel
				+ ", deviceInfo=" + deviceInfo + ", deviceRenderOptions=" + deviceRenderOptions + ", dsReferenceNumber="
				+ dsReferenceNumber + ", dsTransID=" + dsTransID + ", dsURL=" + dsURL + ", payTokenInd=" + payTokenInd
				+ ", payTokenSource=" + payTokenSource + ", purchaseInstalData=" + purchaseInstalData + ", mcc=" + mcc
				+ ", merchantCountryCode=" + merchantCountryCode + ", merchantName=" + merchantName
				+ ", merchantRiskIndicator=" + merchantRiskIndicator + ", messageCategory=" + messageCategory
				+ ", messageExtension=" + messageExtension + ", messageType=" + messageType + ", messageVersion="
				+ messageVersion + ", acsReferenceNumber=" + acsReferenceNumber + ", acsRenderingType="
				+ acsRenderingType + ", acsSignedContent=" + acsSignedContent + ", acsTransID=" + acsTransID
				+ ", authenticationType=" + authenticationType + ", authenticationValue="
				+ authenticationValue + ", broadInfo=" + broadInfo + ", cardholderInfo=" + cardholderInfo + ", eci="
				+ eci + ", sdkTransID=" + sdkTransID + ", transStatus=" + transStatus + ", transStatusReason="
				+ transStatusReason + ", whiteListStatus=" + whiteListStatus + ", whiteListStatusSource="
				+ whiteListStatusSource + ", acquirerBIN=" + acquirerBIN + ", acquirerMerchantID=" + acquirerMerchantID
				+ ", addrMatch=" + addrMatch + ", browserAcceptHeader=" + browserAcceptHeader + ", browserIP="
				+ browserIP + ", browserJavaEnabled=" + browserJavaEnabled + ", browserJavascriptEnabled="
				+ browserJavascriptEnabled + ", browserLanguage=" + browserLanguage + ", browserColorDepth="
				+ browserColorDepth + ", browserScreenHeight=" + browserScreenHeight + ", browserScreenWidth="
				+ browserScreenWidth + ", browserTZ=" + browserTZ + ", browserUserAgent=" + browserUserAgent
				+ ", cardExpiryDate=" + cardExpiryDate + ", acctInfo=" + acctInfo + ", acctNumber=" + acctNumber
				+ ", acctID=" + acctID + ", billAddrCity=" + billAddrCity + ", billAddrCountry=" + billAddrCountry
				+ ", billAddrLine1=" + billAddrLine1 + ", billAddrLine2=" + billAddrLine2 + ", billAddrLine3="
				+ billAddrLine3 + ", billAddrPostCode=" + billAddrPostCode + ", billAddrState=" + billAddrState
				+ ", email=" + email + ", homePhone=" + homePhone + ", notificationURL=" + notificationURL
				+ ", purchaseAmount=" + purchaseAmount + ", purchaseCurrency=" + purchaseCurrency
				+ ", purchaseExponent=" + purchaseExponent + ", purchaseDate=" + purchaseDate + ", recurringExpiry="
				+ recurringExpiry + ", recurringFrequency=" + recurringFrequency + ", sdkAppID=" + sdkAppID
				+ ", sdkEncData=" + sdkEncData + ", sdkEphemPubKey=" + sdkEphemPubKey + ", sdkMaxTimeout="
				+ sdkMaxTimeout + ", sdkReferenceNumber=" + sdkReferenceNumber + ", transType=" + transType + "]";
	}
	
	
	
	
	
}
