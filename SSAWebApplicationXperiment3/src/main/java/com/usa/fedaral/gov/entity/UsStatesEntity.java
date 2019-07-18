package com.usa.fedaral.gov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATES_MASTER")
public class UsStatesEntity {
	@Id
	@Column(name="STATE_ID")
	private int stateId;
	@Column(name="STATE_CODE")
	private String stateCode;
	@Column(name="STATE_NAME")
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
