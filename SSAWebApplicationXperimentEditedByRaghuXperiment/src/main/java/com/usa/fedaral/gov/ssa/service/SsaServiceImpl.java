package com.usa.fedaral.gov.ssa.service;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
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
import com.usa.fedaral.gov.ssa.model.StatesModel;
import com.usa.fedaral.gov.ssa.repository.SsnMasterRepository;
import com.usa.fedaral.gov.ssa.repository.StatesMasterRepository;

@Service
public class SsaServiceImpl extends Exception implements SsaService {

	@Autowired
	private SsnMasterRepository ssnMasterRepository;

	@Autowired
	private StatesMasterRepository statesMasterRepository;

	@Override
	public String insertUserData(SsnModel model) {
		SsnMasterEntity entity = new SsnMasterEntity();
		BeanUtils.copyProperties(model, entity);
		SsnMasterEntity res = ssnMasterRepository.save(entity);
		System.out.println(res.getSsnNumber() + "" + (res.getSsnNumber() > 0));
		System.out.println(res.getSsnNumber());
		BeanUtils.copyProperties(res, model);
		String ssnNumberString = String.valueOf(model.getSsnNumber());
		String ssnNumber = ssnNumberString.substring(0, 4)+"-"+ssnNumberString.substring(4,6)+"-"+ssnNumberString.substring(6, 9);
		return ssnNumber;
	}

	@Override
	public List getStatesList() {
		List<StatesMasterEntity> statesMasterEntity = statesMasterRepository.findAll();
		List ssnModelList = new ArrayList();
		for (StatesMasterEntity entity : statesMasterEntity) {
			StatesModel statesModel = new StatesModel();
			BeanUtils.copyProperties(entity, statesModel);
			ssnModelList.add(statesModel.getStateName());
		}
		return ssnModelList;
	}

	@Override
	public List<SsnModel> getAllSsnRecords() {
		List<SsnModel> ssnModelList = new ArrayList();
		List<SsnMasterEntity> ssnMasterEntityList = ssnMasterRepository.findAll();
		for (SsnMasterEntity ssnMasterOne : ssnMasterEntityList) {
			SsnModel ssnModelOne = new SsnModel();
			BeanUtils.copyProperties(ssnMasterOne, ssnModelOne);
			ssnModelList.add(ssnModelOne);
		}
		System.out.println(ssnMasterEntityList);
		return ssnModelList;
	}

	@Override
	public String getStateNameById(Long ssnNumber) {
		String state = null;
		Optional<SsnMasterEntity> ssnMasterEntity = ssnMasterRepository.findById(ssnNumber);
		if (ssnMasterEntity.isPresent()) {
			SsnMasterEntity ssnValid = ssnMasterEntity.get();
			state = ssnValid.getState();
			System.out.println(state);
		} else {
			throw new SsaRestException("Citizen SsnNumber not found with SsnNumber" + ssnNumber);
		}
		return state;
	}

	/*@Override
	public List<SsnModel> getImages() {
		List<SsnMasterEntity> dataList = ssnMasterRepository.findAll();
		
		List imagesList = new ArrayList(dataList.size());
		for(SsnMasterEntity images : dataList) {
			SsnModel ssnModel = new SsnModel();
			BeanUtils.copyProperties(images, ssnModel);
			imagesList.add(images.getPhoto());
			
		}
		return imagesList;
	}*/
	
	public byte[] getImageById(Long ssnNumber) {
		byte[] image;
		Optional<SsnMasterEntity> ssnMasterEntity = ssnMasterRepository.findById(ssnNumber);
		
			if (ssnMasterEntity.isPresent()) {
				SsnMasterEntity ssnValid = ssnMasterEntity.get();
				 image= ssnValid.getPhoto();
					} else {
				throw new SsaRestException("Photo not found" + ssnNumber);
			}
			return image;
	}

}
