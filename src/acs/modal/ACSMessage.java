package acs.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ACS_MESSAGE")
public class ACSMessage implements java.io.Serializable {

	private int id;
	private String areqMessage;
	private String aresMessage;
	private Date operationDate;
	
	
	
	public ACSMessage() {		
	}

	public ACSMessage(int id, String areqMessage, String aresMessage, Date operationDate) {

		this.id = id;
		this.areqMessage = areqMessage;
		this.aresMessage = aresMessage;
		this.operationDate = operationDate;
	}
	
	@Column(name = "OPERATION_DATE", length = 10)
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	
	@Id
	@Column(name = "ID", length = 20)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "AREQ_MSG", length = 1000)
	public String getAreqMessage() {
		return areqMessage;
	}
	
	public void setAreqMessage(String areqMessage) {
		this.areqMessage = areqMessage;
	}
	
	@Column(name = "ARES_MSG", length = 1000)
	public String getAresMessage() {
		return aresMessage;
	}
	
	public void setAresMessage(String aresMessage) {
		this.aresMessage = aresMessage;
	}

	@Override
	public String toString() {
		return "ACSMessage [id=" + id + ", areqMessage=" + areqMessage + ", aresMessage=" + aresMessage
				+ ", operationDate=" + operationDate + "]";
	}

	
}
