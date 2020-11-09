package acs.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class FieldDefinitionId implements java.io.Serializable {

	private String tag;
	private String lang;

	public FieldDefinitionId() {
	}

	public FieldDefinitionId(String tag, String lang) {
		this.tag = tag;
		this.lang = lang;
	}

	@Column(name = "TAG", length = 1)
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "LANG", length = 1)
	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	

}
