package acs.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class PageAccessParamId implements java.io.Serializable {


	private String role;

	private String page;

	
	public PageAccessParamId() {
	}

	/** full constructor */
	public PageAccessParamId(String role, String page) {
		this.role = role;
		this.page = page;
	}

	@Column(name = "ROLE", length = 50)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "PAGE", length = 50)
	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	

}