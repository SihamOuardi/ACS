package acs.modal;

import java.sql.Blob;

public class AcsInstitution implements java.io.Serializable {

	private String institutionCode;
	private String wording;
	private String currencyCode;
	private String address;
	private String countryCode;
	private String zipCode;
	private String cityCode;
	private String logoName;
	private Blob logo;

	public AcsInstitution() {
	}

	public AcsInstitution(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public AcsInstitution(String institutionCode, String wording,
			String currencyCode, String address, String countryCode,
			String zipCode, String cityCode, String logoName, Blob logo) {
		this.institutionCode = institutionCode;
		this.wording = wording;
		this.currencyCode = currencyCode;
		this.address = address;
		this.countryCode = countryCode;
		this.zipCode = zipCode;
		this.cityCode = cityCode;
		this.logoName = logoName;
		this.logo = logo;
	}

	public String getInstitutionCode() {
		return this.institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getLogoName() {
		return this.logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public Blob getLogo() {
		return this.logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

}
