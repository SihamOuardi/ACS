package acs.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// Generated 2 d�c. 2016 11:01:38 by Hibernate Tools 3.4.0.CR1

/**
 * PageId generated by hbm2java
 */
@Embeddable
public class PageId implements java.io.Serializable {

	private String productCode;
	private String pageCode;
	private String tagCode;
	private String tagValue;

	public PageId() {
	}

	public PageId(String productCode, String pageCode, String tagCode,
			String tagValue) {
		this.productCode = productCode;
		this.pageCode = pageCode;
		this.tagCode = tagCode;
		this.tagValue = tagValue;
	}
	
	@Column(name = "PRODUCT_CODE", length = 3)
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@Column(name = "PAGE_CODE", length = 25)
	public String getPageCode() {
		return this.pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}
	
	@Column(name = "TAG_CODE", length = 8)
	public String getTagCode() {
		return this.tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	@Column(name = "TAG_VALUE", length = 3)
	public String getTagValue() {
		return this.tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PageId))
			return false;
		PageId castOther = (PageId) other;

		return ((this.getProductCode() == castOther.getProductCode()) || (this
				.getProductCode() != null && castOther.getProductCode() != null && this
				.getProductCode().equals(castOther.getProductCode())))
				&& ((this.getPageCode() == castOther.getPageCode()) || (this
						.getPageCode() != null
						&& castOther.getPageCode() != null && this
						.getPageCode().equals(castOther.getPageCode())))
				&& ((this.getTagCode() == castOther.getTagCode()) || (this
						.getTagCode() != null && castOther.getTagCode() != null && this
						.getTagCode().equals(castOther.getTagCode())))
				&& ((this.getTagValue() == castOther.getTagValue()) || (this
						.getTagValue() != null
						&& castOther.getTagValue() != null && this
						.getTagValue().equals(castOther.getTagValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getProductCode() == null ? 0 : this.getProductCode()
						.hashCode());
		result = 37 * result
				+ (getPageCode() == null ? 0 : this.getPageCode().hashCode());
		result = 37 * result
				+ (getTagCode() == null ? 0 : this.getTagCode().hashCode());
		result = 37 * result
				+ (getTagValue() == null ? 0 : this.getTagValue().hashCode());
		return result;
	}

}
