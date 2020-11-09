package acs.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RangeParametersId implements java.io.Serializable {

	private String bankCode;
	private String lowRange;
	private String highRange;
	
	@Column(name = "BANK_CODE", length = 5)
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	@Column(name = "LOW_RANGE", length = 24)
	public String getLowRange() {
		return lowRange;
	}
	public void setLowRange(String lowRange) {
		this.lowRange = lowRange;
	}
	
	@Column(name = "HIGH_RANGE", length = 24)
	public String getHighRange() {
		return highRange;
	}
	public void setHighRange(String highRange) {
		this.highRange = highRange;
	}
	
	
	
}
