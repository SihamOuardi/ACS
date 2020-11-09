package acs.message;

import java.util.ArrayList;

public class RangeData {
	
private String threeDSMethodURL;
private String acsEndProtocolVersion;
private ArrayList<String> acsInfoInd;
private String acsStartProtocolVersion;
private String actionInd;
private String dsEndProtocolVersion;
private String dsStartProtocolVersion;
private String endRange;
private String startRange;


public RangeData() {
	super();
}
public RangeData(String threeDSMethodURL, String acsEndProtocolVersion, ArrayList<String> acsInfoInd,
		String acsStartProtocolVersion, String actionInd, String dsEndProtocolVersion, String dsStartProtocolVersion,
		String endRange, String startRange) {
	super();
	this.threeDSMethodURL = threeDSMethodURL;
	this.acsEndProtocolVersion = acsEndProtocolVersion;
	this.acsInfoInd = acsInfoInd;
	this.acsStartProtocolVersion = acsStartProtocolVersion;
	this.actionInd = actionInd;
	this.dsEndProtocolVersion = dsEndProtocolVersion;
	this.dsStartProtocolVersion = dsStartProtocolVersion;
	this.endRange = endRange;
	this.startRange = startRange;
}
public String getThreeDSMethodURL() {
	return threeDSMethodURL;
}
public void setThreeDSMethodURL(String threeDSMethodURL) {
	this.threeDSMethodURL = threeDSMethodURL;
}
public String getAcsEndProtocolVersion() {
	return acsEndProtocolVersion;
}
public void setAcsEndProtocolVersion(String acsEndProtocolVersion) {
	this.acsEndProtocolVersion = acsEndProtocolVersion;
}
public ArrayList<String> getAcsInfoInd() {
	return acsInfoInd;
}
public void setAcsInfoInd(ArrayList<String> acsInfoInd) {
	this.acsInfoInd = acsInfoInd;
}
public String getAcsStartProtocolVersion() {
	return acsStartProtocolVersion;
}
public void setAcsStartProtocolVersion(String acsStartProtocolVersion) {
	this.acsStartProtocolVersion = acsStartProtocolVersion;
}
public String getActionInd() {
	return actionInd;
}
public void setActionInd(String actionInd) {
	this.actionInd = actionInd;
}
public String getDsEndProtocolVersion() {
	return dsEndProtocolVersion;
}
public void setDsEndProtocolVersion(String dsEndProtocolVersion) {
	this.dsEndProtocolVersion = dsEndProtocolVersion;
}
public String getDsStartProtocolVersion() {
	return dsStartProtocolVersion;
}
public void setDsStartProtocolVersion(String dsStartProtocolVersion) {
	this.dsStartProtocolVersion = dsStartProtocolVersion;
}
public String getEndRange() {
	return endRange;
}
public void setEndRange(String endRange) {
	this.endRange = endRange;
}
public String getStartRange() {
	return startRange;
}
public void setStartRange(String startRange) {
	this.startRange = startRange;
}



}
