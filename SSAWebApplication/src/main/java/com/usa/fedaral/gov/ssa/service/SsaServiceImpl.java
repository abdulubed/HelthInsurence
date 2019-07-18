package com.usa.fedaral.gov.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;
import com.usa.fedaral.gov.ssa.entity.StatesMasterEntity;
import com.usa.fedaral.gov.ssa.repository.SsnMasterRepository;
import com.usa.fedaral.gov.ssa.repository.StatesMasterRepository;

@Service
public class SsaServiceImpl implements SsaService {

	@Autowired
	private SsnMasterRepository ssnMasterRepository;
	
	@Autowired
	private StatesMasterRepository statesMasterRepository;

	@Override
	public void insertUserData(SsnMasterEntity entity) {

		ssnMasterRepository.save(entity);

	}

	@Override
	public Iterable<StatesMasterEntity> getStatesList(StatesMasterEntity entity) {
		
		/*
		 * Iterable<StatesMasterEntity> list = statesMasterRepository.findAll();
		 * System.out.println(list); return list;
		 */
		
		return statesMasterRepository.findAll();
	}

}
