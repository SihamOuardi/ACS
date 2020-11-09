package acs.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AcsCardDataId implements java.io.Serializable {

	private String cardNumber;
	private String institutionCode;

	public AcsCardDataId() {
	}

	public AcsCardDataId(String cardNumber, String institutionCode) {
		this.cardNumber = cardNumber;
		this.institutionCode = institutionCode;
	}

	@Column(name = "CARD_NUMBER", length = 3)
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name = "INSTITUTION_CODE", length = 3)
	public String getInstitutionCode() {
		return this.institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AcsCardDataId))
			return false;
		AcsCardDataId castOther = (AcsCardDataId) other;

		return ((this.getCardNumber() == castOther.getCardNumber()) || (this
				.getCardNumber() != null && castOther.getCardNumber() != null && this
				.getCardNumber().equals(castOther.getCardNumber())))
				&& ((this.getInstitutionCode() == castOther
						.getInstitutionCode()) || (this.getInstitutionCode() != null
						&& castOther.getInstitutionCode() != null && this
						.getInstitutionCode().equals(
								castOther.getInstitutionCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCardNumber() == null ? 0 : this.getCardNumber()
						.hashCode());
		result = 37
				* result
				+ (getInstitutionCode() == null ? 0 : this.getInstitutionCode()
						.hashCode());
		return result;
	}

}
