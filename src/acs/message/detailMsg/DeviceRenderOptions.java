package acs.message.detailMsg;

public class DeviceRenderOptions {

	private String sdkInterface;
	private String[] sdkUiType;
	
	
	
	
	public DeviceRenderOptions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceRenderOptions(String sdkInterface, String[] sdkUiType) {
		super();
		this.sdkInterface = sdkInterface;
		this.sdkUiType = sdkUiType;
	}
	public String getSdkInterface() {
		return sdkInterface;
	}
	public void setSdkInterface(String sdkInterface) {
		this.sdkInterface = sdkInterface;
	}
	public String[] getSdkUiType() {
		return sdkUiType;
	}
	public void setSdkUiType(String[] sdkUiType) {
		this.sdkUiType = sdkUiType;
	}
	
	
}
