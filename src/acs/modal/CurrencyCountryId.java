package acs.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CurrencyCountryId implements java.io.Serializable {

	private String currencyCode;
	private String wording;
	private Byte exponent;
	private String isoCurrencyAlpha;
	private String countryCode;
	private String wordingCountry;
	private String countryLabelVisa;
	private String isoCountryAlpha;

	public CurrencyCountryId() {
	}

	public CurrencyCountryId(String currencyCode, String wording,
			Byte exponent, String isoCurrencyAlpha, String countryCode,
			String wordingCountry, String countryLabelVisa,
			String isoCountryAlpha) {
		this.currencyCode = currencyCode;
		this.wording = wording;
		this.exponent = exponent;
		this.isoCurrencyAlpha = isoCurrencyAlpha;
		this.countryCode = countryCode;
		this.wordingCountry = wordingCountry;
		this.countryLabelVisa = countryLabelVisa;
		this.isoCountryAlpha = isoCountryAlpha;
	}

	@Column(name = "CURRENCY_CODE", length = 3)
	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Column(name = "WORDING", length = 30)
	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	@Column(name = "EXPONENT", length = 1)
	public Byte getExponent() {
		return this.exponent;
	}

	public void setExponent(Byte exponent) {
		this.exponent = exponent;
	}

	@Column(name = "ISO_CURRENCY_ALPHA", length = 3)
	public String getIsoCurrencyAlpha() {
		return this.isoCurrencyAlpha;
	}

	public void setIsoCurrencyAlpha(String isoCurrencyAlpha) {
		this.isoCurrencyAlpha = isoCurrencyAlpha;
	}

	@Column(name = "COUNTRY_CODE", length = 3)
	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Column(name = "WORDING_COUNTRY", length = 30)
	public String getWordingCountry() {
		return this.wordingCountry;
	}

	public void setWordingCountry(String wordingCountry) {
		this.wordingCountry = wordingCountry;
	}
	
	@Column(name = "COUNTRY_LABEL_VISA", length = 2)
	public String getCountryLabelVisa() {
		return this.countryLabelVisa;
	}

	public void setCountryLabelVisa(String countryLabelVisa) {
		this.countryLabelVisa = countryLabelVisa;
	}

	@Column(name = "ISO_COUNTRY_ALPHA", length = 3)
	public String getIsoCountryAlpha() {
		return this.isoCountryAlpha;
	}

	public void setIsoCountryAlpha(String isoCountryAlpha) {
		this.isoCountryAlpha = isoCountryAlpha;
	}

	
	

}
