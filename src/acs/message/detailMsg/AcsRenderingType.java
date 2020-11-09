package acs.message.detailMsg;

public class AcsRenderingType {
	
	private String acsInterface;
	private String acsUiTemplate;
	
	
	
	public AcsRenderingType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AcsRenderingType(String acsInterface, String acsUiTemplate) {
		super();
		this.acsInterface = acsInterface;
		this.acsUiTemplate = acsUiTemplate;
	}
	public String getAcsInterface() {
		return acsInterface;
	}
	public void setAcsInterface(String acsInterface) {
		this.acsInterface = acsInterface;
	}
	public String getAcsUiTemplate() {
		return acsUiTemplate;
	}
	public void setAcsUiTemplate(String acsUiTemplate) {
		this.acsUiTemplate = acsUiTemplate;
	}

	
}
