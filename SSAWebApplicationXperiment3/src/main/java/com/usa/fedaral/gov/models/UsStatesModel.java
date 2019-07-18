package com.usa.fedaral.gov.models;

public class UsStatesModel {
private int stateId;
private String stateCode;
private String stateName;
public int getStateId() {
	return stateId;
}
public void setStateId(int stateId) {
	this.stateId = stateId;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getStateName() {
	return stateName;
}
public void setStateName(String stateName) {
	this.stateName = stateName;
}
@Override
public String toString() {
	return "UsStatesModel [stateId=" + stateId + ", stateCode=" + stateCode + ", stateName=" + stateName + "]";
}

}
