package acs.message.riskIndicator;

public class ThreeDSRequestorAuthenticationInfo {

	private String threeDSReqAuthData;
	private String threeDSReqAuthMethod;
	private String threeDSReqAuthTimestamp;
	
	
	
	public ThreeDSRequestorAuthenticationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThreeDSRequestorAuthenticationInfo(String threeDSReqAuthData, String threeDSReqAuthMethod,
			String threeDSReqAuthTimestamp) {
		super();
		this.threeDSReqAuthData = threeDSReqAuthData;
		this.threeDSReqAuthMethod = threeDSReqAuthMethod;
		this.threeDSReqAuthTimestamp = threeDSReqAuthTimestamp;
	}
	public String getThreeDSReqAuthData() {
		return threeDSReqAuthData;
	}
	public void setThreeDSReqAuthData(String threeDSReqAuthData) {
		this.threeDSReqAuthData = threeDSReqAuthData;
	}
	public String getThreeDSReqAuthMethod() {
		return threeDSReqAuthMethod;
	}
	public void setThreeDSReqAuthMethod(String threeDSReqAuthMethod) {
		this.threeDSReqAuthMethod = threeDSReqAuthMethod;
	}
	public String getThreeDSReqAuthTimestamp() {
		return threeDSReqAuthTimestamp;
	}
	public void setThreeDSReqAuthTimestamp(String threeDSReqAuthTimestamp) {
		this.threeDSReqAuthTimestamp = threeDSReqAuthTimestamp;
	}
	@Override
	public String toString() {
		return "ThreeDSRequestorAuthenticationInfo [threeDSReqAuthData=" + threeDSReqAuthData
				+ ", threeDSReqAuthMethod=" + threeDSReqAuthMethod + ", threeDSReqAuthTimestamp="
				+ threeDSReqAuthTimestamp + "]";
	}

	
}
