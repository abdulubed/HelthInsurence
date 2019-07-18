package com.usa.fedaral.gov.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;
import com.usa.fedaral.gov.ssa.entity.StatesMasterEntity;
import com.usa.fedaral.gov.ssa.model.SsnModel;
import com.usa.fedaral.gov.ssa.model.StatesModel;
import com.usa.fedaral.gov.ssa.service.SsaServiceImpl;
import com.usa.fedaral.gov.ssa.util.AppProperties;

/**
 * @author Abdul
 *
 */
@Controller
public class SsaController {

	@Autowired
	private SsaServiceImpl ssaServiceImpl;

	@Autowired
	private AppProperties appProperties;

	/**
	 * this method is for display ssn enrollment form
	 * 
	 * @param model
	 * @return userRegistraion jsp page
	 */
	@RequestMapping("/displayForm")
	public String displayForm(Model model) {
		model.addAttribute("ssnModel", new SsnModel());
		gendersList(model);
		getStatesList(model);
		return appProperties.getUserRegistration();
	}

	/**
	 * this method is for adding male & female radio buttons to model
	 * 
	 * @param model
	 * @return userRegistration page jsp page
	 */
	public String gendersList(Model model) {
		List gendersList = new ArrayList();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("gendersList", gendersList);
		return appProperties.getUserRegistration();
	}

	/**
	 * this method is for form registration
	 * 
	 * @param model
	 * @param ssnMasterEntiry
	 * @param ssnModel
	 * @return userRegistration jsp page
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/insertUserData")
	public String insertUserData(Model model, SsnMasterEntity ssnMasterEntiry,@Valid SsnModel ssnModel,BindingResult result) {
		
		model.addAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
		
		if(result.hasErrors()) {
			gendersList(model);
			getStatesList(model);
			return appProperties.getUserRegistration();
		}
		gendersList(model);
		getStatesList(model);
		ssaServiceImpl.insertUserData(ssnModel);
		return appProperties.getUserRegistration();
	}

	public String getStatesList(Model model) {

		
		  List<StatesModel> statesList =ssaServiceImpl.getStatesList(); 
		 
		  List<String> allRecords = new ArrayList();
		  for(StatesModel statesModel : statesList) {
			  	String stateName = statesModel.getStateName();
			  	allRecords.add(stateName);
		  }
		  
		  
		  model.addAttribute("list", statesList);
		  return appProperties.getUserRegistration();
		 
		/*
		 * List statesList = new ArrayList(); statesList.add("washington");
		 * statesList.add("florida"); statesList.add("california");
		 * model.addAttribute("statesList", statesList); return
		 * appProperties.getUserRegistration();
		 */
	}

}
