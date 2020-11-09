package acs.modal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RANGE_PARAMETERS")
public class RangeParameters {
    
	
	private RangeParametersId id;
	
	private Character onusFlag;
	private String networkType;
	private String networkWording;
	private Character localFlag;
	

	
	public RangeParameters() {
		
	}
		
	
	public RangeParameters(RangeParametersId id, Character onusFlag, String networkType, String networkWording,
			Character localFlag) {

		this.id = id;
		this.onusFlag = onusFlag;
		this.networkType = networkType;
		this.networkWording = networkWording;
		this.localFlag = localFlag;
	}


	@EmbeddedId
	@AttributeOverrides({			
		    @AttributeOverride(name = "bankCode", column = @Column(name = "BANK_CODE", length = 5)),
			@AttributeOverride(name = "lowRange", column = @Column(name = "LOW_RANGE", length = 25)), 
			@AttributeOverride(name = "highRange", column = @Column(name = "HIGH_RANGE", length = 25)),											
	})
	public RangeParametersId getId() {
		return id;
	}
	public void setId(RangeParametersId id) {
		this.id = id;
	}
	

	@Column(name = "ONUS_FLAG", length = 3)
	public Character getOnusFlag() {
		return onusFlag;
	}
	public void setOnusFlag(Character onusFlag) {
		this.onusFlag = onusFlag;
	}
	
	@Column(name = "NETWORK_TYPE", length = 3)
	public String getNetworkType() {
		return networkType;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	
	public String getNetworkWording() {
		return networkWording;
	}
	public void setNetworkWording(String networkWording) {
		this.networkWording = networkWording;
	}
	

	@Column(name = "LOCAL_FLAG", length = 3)
	public Character getLocalFlag() {
		return localFlag;
	}
	public void setLocalFlag(Character localFlag) {
		this.localFlag = localFlag;
	}
	
	
	
}
