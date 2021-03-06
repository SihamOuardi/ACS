package acs.modal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;

// Generated 2 d�c. 2016 11:01:38 by Hibernate Tools 3.4.0.CR1

/**
 * Page generated by hbm2java
 */
public class Page implements java.io.Serializable {

	@EmbeddedId
	@AttributeOverrides({			
		    @AttributeOverride(name = "productCode", column = @Column(name = "PRODUCT_CODE", length = 8)),
			@AttributeOverride(name = "pageCode", column = @Column(name = "PAGE_CODE", length = 25)), 
			@AttributeOverride(name = "tagCode", column = @Column(name = "TAG_CODE", length = 8)),											
			@AttributeOverride(name = "tagValue", column = @Column(name = "TAG_VALUE", length = 25)),					
			})
	private PageId id;

	public Page() {
	}

	public Page(PageId id) {
		this.id = id;
	}

	public PageId getId() {
		return this.id;
	}

	public void setId(PageId id) {
		this.id = id;
	}

}
