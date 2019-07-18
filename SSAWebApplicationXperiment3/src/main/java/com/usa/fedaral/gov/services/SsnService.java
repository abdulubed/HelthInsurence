package com.usa.fedaral.gov.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.fedaral.gov.entity.SsnEntity;
import com.usa.fedaral.gov.entity.UsStatesEntity;
import com.usa.fedaral.gov.exception.SsaRestException;
import com.usa.fedaral.gov.models.UsStatesModel;
import com.usa.fedaral.gov.models.ssnfrommodel;
import com.usa.fedaral.gov.properties.Applicationproperties;
import com.usa.fedaral.gov.repository.SsnEnrollRepository;
import com.usa.fedaral.gov.repository.UsStatesRepository;

@Service
public class SsnService {
	@Autowired
	private UsStatesRepository usstatesrepo;
	@Autowired
	private SsnEnrollRepository ssnEnrollRepo;
	@Autowired
	private Applicationproperties applicationProperties;

	/*
	 * This method is To Get All The States from DB
	 */
	public List<UsStatesModel> getstates() {
		List<UsStatesEntity> le = usstatesrepo.findAll();
		List<UsStatesModel> lm = new ArrayList();
		for (UsStatesEntity usStatesEntity : le) {
			UsStatesModel use = new UsStatesModel();
			BeanUtils.copyProperties(usStatesEntity, use);
			lm.add(use);
		}
		return lm;
	}

	/*
	 * This Method is to Insert the SSnEnroll Data into DB
	 */
	public boolean insertSsnEnoll(ssnfrommodel ssnModel) {
		SsnEntity ssnEntity = new SsnEntity();
		BeanUtils.copyProperties(ssnModel, ssnEntity);
		SsnEntity res = ssnEnrollRepo.save(ssnEntity);
		System.out.println(res.getSsnNo() + "" + (res.getSsnNo() > 0));
		return res.getSsnNo() > 0;
	}

	/*
	 * This Method is To Retrive all the Records from DB
	 */
	public List<ssnfrommodel> retriveAllSsnRecords() {
		List<ssnfrommodel> lsm = new ArrayList();
		List<SsnEntity> lse = ssnEnrollRepo.findAll();
		for (SsnEntity ssnEntity : lse) {
			ssnfrommodel ssnmodel = new ssnfrommodel();
			BeanUtils.copyProperties(ssnEntity, ssnmodel);
			lsm.add(ssnmodel);
		}
		return lsm;
	}

	/*
	 * This Method is for getting The Record By SsnNo
	 */
	public ssnfrommodel updateSsnRecordById(int ssnno) {
		ssnfrommodel model = new ssnfrommodel();
		Optional<SsnEntity> lse = ssnEnrollRepo.findById(ssnno);
		System.out.println(lse.isPresent());
		// System.out.println("ssnentity" + ssnentity);
		if (lse.isPresent()) {
			// ssnfrommodel model=new ssnfrommodel();
			// System.out.println(lse.toString());
			System.out.println("ssn extraxting" + lse.get());
			SsnEntity ssnentity = lse.get();
			System.out.println(ssnentity);
			BeanUtils.copyProperties(ssnentity, model);
			// System.out.println("ssn extraxting model"+model);
		}
		return model;
	}

	/*
	 * This Method is To Update the Record
	 */
	public boolean updateSsnEnoll(ssnfrommodel ssnmodel) {
		SsnEntity ssnentity = new SsnEntity();
		ssnmodel.setSsnNo(ssnmodel.getSsnNo());
		BeanUtils.copyProperties(ssnmodel, ssnentity);
		SsnEntity lse = ssnEnrollRepo.save(ssnentity);
		return lse.getSsnNo() == ssnmodel.getSsnNo();
	}

	/*
	 * This Method is calling from RestController
	 * 
	 * This Method is To find the StateName By SsnNo
	 */
	public String findStateBySsn(int ssn) {
		String statename = null;
		Optional<SsnEntity> optionalEntity = ssnEnrollRepo.findById(ssn);
		if (optionalEntity.isPresent()) {
			SsnEntity entity = optionalEntity.get();
			statename = entity.getState();
		} else {
			// System.out.println(applicationProperties.getException().get("excepMsg"));
			throw new SsaRestException(applicationProperties.getException().get("excepMsg"));
		}
		return statename;
	}
}
