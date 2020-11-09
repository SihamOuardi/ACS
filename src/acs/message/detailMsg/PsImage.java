package acs.message.detailMsg;

public class PsImage {

	private String medium;
	private String high;
	private String extraHigh;
	
	public PsImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PsImage(String medium, String high, String extraHigh) {
		super();
		this.medium = medium;
		this.high = high;
		this.extraHigh = extraHigh;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getExtraHigh() {
		return extraHigh;
	}
	public void setExtraHigh(String extraHigh) {
		this.extraHigh = extraHigh;
	}

	
	
}
