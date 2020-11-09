package acs.message;

import java.util.Map;

public class MessageExtension {
	
	private Boolean criticalityIndicator;
	private Map<String , String> data ;
	private String id ;
	private String name ;
	
	public MessageExtension() {
		super();
	}
	
	
	public MessageExtension(Boolean criticalityIndicator, Map<String, String> data, String id, String name) {
		this.criticalityIndicator = criticalityIndicator;
		this.data = data;
		this.id = id;
		this.name = name;
	}


	public Boolean getCriticalityIndicator() {
		return criticalityIndicator;
	}
	public void setCriticalityIndicator(Boolean criticalityIndicator) {
		this.criticalityIndicator = criticalityIndicator;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
