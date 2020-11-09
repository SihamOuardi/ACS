package acs.modal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_COUNTRY")
public class CurrencyCountry implements java.io.Serializable {

	private CurrencyCountryId id;

	public CurrencyCountry() {
	
	}

	public CurrencyCountry(CurrencyCountryId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "currencyCode", column = @Column(name = "CURRENCY_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "wording", column = @Column(name = "WORDING", nullable = false, length = 3)),
			@AttributeOverride(name = "exponent", column = @Column(name = "EXPONENT", nullable = false, length = 3)),
			@AttributeOverride(name = "isoCurrencyAlpha", column = @Column(name = "ISO_CURRENCY_ALPHA", nullable = false, length = 3)),
			@AttributeOverride(name = "countryCode", column = @Column(name = "COUNTRY_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "wordingCountry", column = @Column(name = "WORDING_COUNTRY", nullable = false, length = 3)),
			@AttributeOverride(name = "countryLabelVisa", column = @Column(name = "COUNTRY_LABEL_VISA", nullable = false, length = 3)), 
			@AttributeOverride(name = "isoCountryAlpha", column = @Column(name = "ISO_COUNTRY_ALPHA", nullable = false, length = 3))})
	public CurrencyCountryId getId() {
		return this.id;
	}

	public void setId(CurrencyCountryId id) {
		this.id = id;
	}

}
