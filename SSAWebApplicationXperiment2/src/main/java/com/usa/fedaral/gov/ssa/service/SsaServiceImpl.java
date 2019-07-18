package com.usa.fedaral.gov.ssa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;
import com.usa.fedaral.gov.ssa.entity.StatesMasterEntity;
import com.usa.fedaral.gov.ssa.model.SsnModel;
import com.usa.fedaral.gov.ssa.model.StatesModel;
import com.usa.fedaral.gov.ssa.repository.SsnMasterRepository;
import com.usa.fedaral.gov.ssa.repository.StatesMasterRepository;

@Service
public class SsaServiceImpl implements SsaService {

	@Autowired
	private SsnMasterRepository ssnMasterRepository;
	
	@Autowired
	private StatesMasterRepository statesMasterRepository;

	@Override
	public boolean insertUserData(SsnModel model) {
		
		SsnMasterEntity entity = new SsnMasterEntity();
		BeanUtils.copyProperties(model, entity);
		SsnMasterEntity res =ssnMasterRepository.save(entity);
		System.out.println(res.getSsnNumber()+ "" + (res.getSsnNumber() > 0));
		return res.getSsnNumber()>0;
		
	}

	@Override
	public List<StatesModel> getStatesList() {
		List<StatesMasterEntity> list = statesMasterRepository.findAll();
		List<StatesModel> modelList = new ArrayList();
		for(StatesMasterEntity statesMasterEntity : list) {
			StatesModel model = new StatesModel();
			BeanUtils.copyProperties(statesMasterEntity, model);
			modelList.add(model);
		}
		return modelList;
	}

	/*
	 * @Override public List getStatesList() {
	 * 
	 * 
	 * List list = new ArrayList();
	 * 
	 * List<StatesMasterEntity> list1 = statesMasterRepository.findAll();
	 * 
	 * for(StatesMasterEntity entity : list1) {
	 * 
	 * 
	 * list.add(entity.getStateName());
	 * 
	 * }
	 * 
	 * System.out.println(list); return list;
	 * 
	 * 
	 * //return statesMasterRepository.findAll(); }
	 */
	
}
