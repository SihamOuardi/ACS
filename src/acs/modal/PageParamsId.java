package acs.modal;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PageParamsId implements java.io.Serializable {

	private String codePage;
	private String namePage;
	private Blob logoVisa;
	private String pageHeader;
	private String cardNbr;
	private Date trxDate;
	private BigDecimal amount;

	public PageParamsId() {
	}

	public PageParamsId(String codePage, String namePage, Blob logoVisa,
			String pageHeader, String cardNbr, Date trxDate, BigDecimal amount) {
		this.codePage = codePage;
		this.namePage = namePage;
		this.logoVisa = logoVisa;
		this.pageHeader = pageHeader;
		this.cardNbr = cardNbr;
		this.trxDate = trxDate;
		this.amount = amount;
	}

	@Column(name = "CODE_PAGE", length = 3)
	public String getCodePage() {
		return this.codePage;
	}

	public void setCodePage(String codePage) {
		this.codePage = codePage;
	}
	
	@Column(name = "NAME_PAGE", length = 3)
	public String getNamePage() {
		return this.namePage;
	}

	public void setNamePage(String namePage) {
		this.namePage = namePage;
	}

	@Column(name = "LOGO_VISA", length = 3)
	public Blob getLogoVisa() {
		return this.logoVisa;
	}

	public void setLogoVisa(Blob logoVisa) {
		this.logoVisa = logoVisa;
	}
	
	@Column(name = "PAGE_HEADER", length = 3)
	public String getPageHeader() {
		return this.pageHeader;
	}

	public void setPageHeader(String pageHeader) {
		this.pageHeader = pageHeader;
	}
	
	@Column(name = "CARD_NBR", length = 3)
	public String getCardNbr() {
		return this.cardNbr;
	}

	public void setCardNbr(String cardNbr) {
		this.cardNbr = cardNbr;
	}
	
	@Column(name = "TRX_DATE", length = 3)
	public Date getTrxDate() {
		return this.trxDate;
	}

	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
	}
	
	@Column(name = "AMOUNT", length = 3)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PageParamsId))
			return false;
		PageParamsId castOther = (PageParamsId) other;

		return ((this.getCodePage() == castOther.getCodePage()) || (this
				.getCodePage() != null && castOther.getCodePage() != null && this
				.getCodePage().equals(castOther.getCodePage())))
				&& ((this.getNamePage() == castOther.getNamePage()) || (this
						.getNamePage() != null
						&& castOther.getNamePage() != null && this
						.getNamePage().equals(castOther.getNamePage())))
				&& ((this.getLogoVisa() == castOther.getLogoVisa()) || (this
						.getLogoVisa() != null
						&& castOther.getLogoVisa() != null && this
						.getLogoVisa().equals(castOther.getLogoVisa())))
				&& ((this.getPageHeader() == castOther.getPageHeader()) || (this
						.getPageHeader() != null
						&& castOther.getPageHeader() != null && this
						.getPageHeader().equals(castOther.getPageHeader())))
				&& ((this.getCardNbr() == castOther.getCardNbr()) || (this
						.getCardNbr() != null && castOther.getCardNbr() != null && this
						.getCardNbr().equals(castOther.getCardNbr())))
				&& ((this.getTrxDate() == castOther.getTrxDate()) || (this
						.getTrxDate() != null && castOther.getTrxDate() != null && this
						.getTrxDate().equals(castOther.getTrxDate())))
				&& ((this.getAmount() == castOther.getAmount()) || (this
						.getAmount() != null && castOther.getAmount() != null && this
						.getAmount().equals(castOther.getAmount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodePage() == null ? 0 : this.getCodePage().hashCode());
		result = 37 * result
				+ (getNamePage() == null ? 0 : this.getNamePage().hashCode());
		result = 37 * result
				+ (getLogoVisa() == null ? 0 : this.getLogoVisa().hashCode());
		result = 37
				* result
				+ (getPageHeader() == null ? 0 : this.getPageHeader()
						.hashCode());
		result = 37 * result
				+ (getCardNbr() == null ? 0 : this.getCardNbr().hashCode());
		result = 37 * result
				+ (getTrxDate() == null ? 0 : this.getTrxDate().hashCode());
		result = 37 * result
				+ (getAmount() == null ? 0 : this.getAmount().hashCode());
		return result;
	}

}
