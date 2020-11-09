package acs.modal;

public class AcsPageParams implements java.io.Serializable {

	private String pageParamId;
	private String wording;
	private String tagCode;
	private String taqPixel;
	private String taqBgColor;
	private String taqFont;
	private Byte tagPosition;
	private String taqFgColor;
	private String tagStyle;
	private String tagWeight;

	public AcsPageParams() {
	}

	public AcsPageParams(String pageParamId) {
		this.pageParamId = pageParamId;
	}

	public AcsPageParams(String pageParamId, String wording, String tagCode,
			String taqPixel, String taqBgColor, String taqFont,
			Byte tagPosition, String taqFgColor, String tagStyle,
			String tagWeight) {
		this.pageParamId = pageParamId;
		this.wording = wording;
		this.tagCode = tagCode;
		this.taqPixel = taqPixel;
		this.taqBgColor = taqBgColor;
		this.taqFont = taqFont;
		this.tagPosition = tagPosition;
		this.taqFgColor = taqFgColor;
		this.tagStyle = tagStyle;
		this.tagWeight = tagWeight;
	}

	public String getPageParamId() {
		return this.pageParamId;
	}

	public void setPageParamId(String pageParamId) {
		this.pageParamId = pageParamId;
	}

	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public String getTagCode() {
		return this.tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getTaqPixel() {
		return this.taqPixel;
	}

	public void setTaqPixel(String taqPixel) {
		this.taqPixel = taqPixel;
	}

	public String getTaqBgColor() {
		return this.taqBgColor;
	}

	public void setTaqBgColor(String taqBgColor) {
		this.taqBgColor = taqBgColor;
	}

	public String getTaqFont() {
		return this.taqFont;
	}

	public void setTaqFont(String taqFont) {
		this.taqFont = taqFont;
	}

	public Byte getTagPosition() {
		return this.tagPosition;
	}

	public void setTagPosition(Byte tagPosition) {
		this.tagPosition = tagPosition;
	}

	public String getTaqFgColor() {
		return this.taqFgColor;
	}

	public void setTaqFgColor(String taqFgColor) {
		this.taqFgColor = taqFgColor;
	}

	public String getTagStyle() {
		return this.tagStyle;
	}

	public void setTagStyle(String tagStyle) {
		this.tagStyle = tagStyle;
	}

	public String getTagWeight() {
		return this.tagWeight;
	}

	public void setTagWeight(String tagWeight) {
		this.tagWeight = tagWeight;
	}

}

