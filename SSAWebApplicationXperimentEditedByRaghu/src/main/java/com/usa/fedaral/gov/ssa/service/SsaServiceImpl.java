package com.usa.fedaral.gov.ssa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;
import com.usa.fedaral.gov.ssa.entity.StatesMasterEntity;
import com.usa.fedaral.gov.ssa.exception.SsaRestException;
import com.usa.fedaral.gov.ssa.model.SsnModel;
import com.usa.fedaral.gov.ssa.repository.SsnMasterRepository;
import com.usa.fedaral.gov.ssa.repository.StatesMasterRepository;

@Service
public class SsaServiceImpl extends Exception implements SsaService {

	@Autowired
	private SsnMasterRepository ssnMasterRepository;

	@Autowired
	private StatesMasterRepository statesMasterRepository;

	@Override
	public long insertUserData(SsnModel model) {

		SsnMasterEntity entity = new SsnMasterEntity();
		BeanUtils.copyProperties(model, entity);
		SsnMasterEntity res = ssnMasterRepository.save(entity);
		System.out.println(res.getSsnNumber() + "" + (res.getSsnNumber() > 0));
		return res.getSsnNumber();

	}

	/*
	 * @Override public List<StatesModel> getStatesList() { List<StatesMasterEntity>
	 * list = statesMasterRepository.findAll(); List<StatesModel> modelList = new
	 * ArrayList(); for(StatesMasterEntity statesMasterEntity : list) { StatesModel
	 * model = new StatesModel(); BeanUtils.copyProperties(statesMasterEntity,
	 * model); modelList.add(model); System.out.println(model); } return modelList;
	 * }
	 */

	
	  @Override 
	  
	  public List getStatesList() {  
	  
	  List list = new ArrayList();
	  List<StatesMasterEntity> list1 = statesMasterRepository.findAll();

		for (StatesMasterEntity entity : list1) {
			list.add(entity.getStateName());
		}
	  
	  //System.out.println(list);
	  return list;
	  
	  
	  //return statesMasterRepository.findAll();
	  
	  }

	@Override
	public List<SsnModel> getAllSsnRecords() {
		
		List<SsnModel> ssnModelList = new ArrayList(); 
		
		List<SsnMasterEntity> ssnMasterEntityList = ssnMasterRepository.findAll();
		
		for(SsnMasterEntity ssnMasterOne : ssnMasterEntityList) {
			SsnModel ssnModelOne = new SsnModel();
			BeanUtils.copyProperties(ssnMasterOne, ssnModelOne);
			ssnModelList.add(ssnModelOne);
		}
		
		System.out.println(ssnMasterEntityList);
		return ssnModelList;
	}

	@Override
	public String getStateNameById(Long ssnNumber) {
		
		/*
		 * Optional<SsnMasterEntity> ssnMasterEntity
		 * =ssnMasterRepository.findById(ssnNumber);
		 * 
		 * 
		 * SsnModel ssnModel = new SsnModel();
		 * 
		 * BeanUtils.copyProperties(ssnMasterEntity, ssnModel);
		 * 
		 * System.out.println(ssnModel);
		 * 
		 * return null;
		 */
		
		
		
		String state = null;
		Optional<SsnMasterEntity> ssnMasterEntity = ssnMasterRepository.findById(ssnNumber);
		if(ssnMasterEntity.isPresent()) {
		    SsnMasterEntity ssnValid = ssnMasterEntity.get();
		    state = ssnValid.getState();
		    System.out.println(state);
		    //operate on existingCustomer
		    
		} else {
			throw new SsaRestException("Citizen SsnNumber not found with SsnNumber" +ssnNumber);
			
		}
		return state;
	}
	  
	 
}
