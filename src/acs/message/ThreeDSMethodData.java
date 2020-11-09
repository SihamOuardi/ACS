package acs.message;

public class ThreeDSMethodData {
	
	private String threeDSServerTransID;
	
	private String threeDSMethodNotificationURL ;

	
	
	public ThreeDSMethodData() {
		super();
	}

	public ThreeDSMethodData(String threeDSServerTransID, String threeDSMethodNotificationURL) {
		super();
		this.threeDSServerTransID = threeDSServerTransID;
		this.threeDSMethodNotificationURL = threeDSMethodNotificationURL;
	}

	public String getThreeDSServerTransID() {
		return threeDSServerTransID;
	}

	public void setThreeDSServerTransID(String threeDSServerTransID) {
		this.threeDSServerTransID = threeDSServerTransID;
	}

	public String getThreeDSMethodNotificationURL() {
		return threeDSMethodNotificationURL;
	}

	public void setThreeDSMethodNotificationURL(String threeDSMethodNotificationURL) {
		this.threeDSMethodNotificationURL = threeDSMethodNotificationURL;
	}

	
	
}
