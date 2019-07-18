package com.usa.fedaral.gov.ssa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;
import com.usa.fedaral.gov.ssa.model.SsnModel;
import com.usa.fedaral.gov.ssa.model.StatesModel;

@Service
public interface SsaService {
	
	public long insertUserData(SsnModel model);
	
	public List<StatesModel> getStatesList();
	
	public List<SsnModel> getAllSsnRecords();
		

}
