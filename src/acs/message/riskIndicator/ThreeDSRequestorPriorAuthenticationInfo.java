package acs.message.riskIndicator;

public class ThreeDSRequestorPriorAuthenticationInfo {

	private String threeDSReqPriorAuthData;
	private String threeDSReqPriorAuthMethod;
	private String threeDSReqPriorAuthTimestamp;
	private String threeDSReqPriorRef;
	
	
	
	public ThreeDSRequestorPriorAuthenticationInfo() {
		super();
	}

	public ThreeDSRequestorPriorAuthenticationInfo(String threeDSReqPriorAuthData, String threeDSReqPriorAuthMethod,
			String threeDSReqPriorAuthTimestamp, String threeDSReqPriorRef) {
		super();
		this.threeDSReqPriorAuthData = threeDSReqPriorAuthData;
		this.threeDSReqPriorAuthMethod = threeDSReqPriorAuthMethod;
		this.threeDSReqPriorAuthTimestamp = threeDSReqPriorAuthTimestamp;
		this.threeDSReqPriorRef = threeDSReqPriorRef;
	}
	public String getThreeDSReqPriorAuthData() {
		return threeDSReqPriorAuthData;
	}
	public void setThreeDSReqPriorAuthData(String threeDSReqPriorAuthData) {
		this.threeDSReqPriorAuthData = threeDSReqPriorAuthData;
	}
	public String getThreeDSReqPriorAuthMethod() {
		return threeDSReqPriorAuthMethod;
	}
	public void setThreeDSReqPriorAuthMethod(String threeDSReqPriorAuthMethod) {
		this.threeDSReqPriorAuthMethod = threeDSReqPriorAuthMethod;
	}
	public String getThreeDSReqPriorAuthTimestamp() {
		return threeDSReqPriorAuthTimestamp;
	}
	public void setThreeDSReqPriorAuthTimestamp(String threeDSReqPriorAuthTimestamp) {
		this.threeDSReqPriorAuthTimestamp = threeDSReqPriorAuthTimestamp;
	}
	public String getThreeDSReqPriorRef() {
		return threeDSReqPriorRef;
	}
	public void setThreeDSReqPriorRef(String threeDSReqPriorRef) {
		this.threeDSReqPriorRef = threeDSReqPriorRef;
	}

	@Override
	public String toString() {
		return "ThreeDSRequestorPriorAuthenticationInfo [threeDSReqPriorAuthData=" + threeDSReqPriorAuthData
				+ ", threeDSReqPriorAuthMethod=" + threeDSReqPriorAuthMethod + ", threeDSReqPriorAuthTimestamp="
				+ threeDSReqPriorAuthTimestamp + ", threeDSReqPriorRef=" + threeDSReqPriorRef + "]";
	}
	
	
	
}
