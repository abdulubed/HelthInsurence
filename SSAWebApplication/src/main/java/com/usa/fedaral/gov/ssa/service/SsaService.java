package com.usa.fedaral.gov.ssa.service;

import org.springframework.stereotype.Service;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;
import com.usa.fedaral.gov.ssa.entity.StatesMasterEntity;

@Service
public interface SsaService {
	
	public void insertUserData(SsnMasterEntity entity);
	
	public Iterable<StatesMasterEntity> getStatesList(StatesMasterEntity entity);
		

}
