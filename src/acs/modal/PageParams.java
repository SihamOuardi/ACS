package acs.modal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PAGE_PARAMS")
public class PageParams implements java.io.Serializable {

	private PageParamsId id;

	public PageParams() {
	}

	public PageParams(PageParamsId id) {
		this.id = id; }

	@EmbeddedId
	@AttributeOverrides({			
		    @AttributeOverride(name = "codePage", column = @Column(name = "CODE_PAGE", length = 15)),
			@AttributeOverride(name = "namePage", column = @Column(name = "NAME_PAGE", length = 25)), 
			@AttributeOverride(name = "logoVisa", column = @Column(name = "LOGO_VISA", length = 25)),											
			@AttributeOverride(name = "pageHeader", column = @Column(name = "PAGE_HEADER", length = 25)),					
			@AttributeOverride(name = "cardNbr", column = @Column(name = "CARD_NBR",  length = 25)),		
			@AttributeOverride(name = "trxDate", column = @Column(name = "TRX_DATE",  length = 25)),		
			@AttributeOverride(name = "amount", column = @Column(name = "AMOUNT",  length = 25))		
	})
		
	public PageParamsId getId() {
		return this.id;
	}

	public void setId(PageParamsId id) {
		this.id = id;
	}

}
