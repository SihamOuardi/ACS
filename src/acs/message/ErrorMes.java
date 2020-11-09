package acs.message;

public class ErrorMes {

	public String threeDSServerTransID;
	public String acsTransID;
	public String dsTransID;
	public String errorCode;
	public String errorComponent;
	public String errorDescription;
	public String errorDetail;
	public String errorMessageType;
	public String messageType;
	public String messageVersion;
	public String sdkTransID;
		
	
	public ErrorMes(String threeDSServerTransID, String acsTransID, String dsTransID, String errorCode,
			String errorComponent, String errorDescription, String errorDetail, String errorMessageType,
			String messageType, String messageVersion, String sdkTransID) {
		super();
		this.threeDSServerTransID = threeDSServerTransID;
		this.acsTransID = acsTransID;
		this.dsTransID = dsTransID;
		this.errorCode = errorCode;
		this.errorComponent = errorComponent;
		this.errorDescription = errorDescription;
		this.errorDetail = errorDetail;
		this.errorMessageType = errorMessageType;
		this.messageType = messageType;
		this.messageVersion = messageVersion;
		this.sdkTransID = sdkTransID;
	}
	public ErrorMes() {
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
	public String getDsTransID() {
		return dsTransID;
	}
	public void setDsTransID(String dsTransID) {
		this.dsTransID = dsTransID;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorComponent() {
		return errorComponent;
	}
	public void setErrorComponent(String errorComponent) {
		this.errorComponent = errorComponent;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
	public String getErrorMessageType() {
		return errorMessageType;
	}
	public void setErrorMessageType(String errorMessageType) {
		this.errorMessageType = errorMessageType;
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
	
	
	
}
