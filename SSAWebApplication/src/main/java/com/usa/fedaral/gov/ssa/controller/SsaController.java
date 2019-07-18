package com.usa.fedaral.gov.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;
import com.usa.fedaral.gov.ssa.entity.StatesMasterEntity;
import com.usa.fedaral.gov.ssa.model.SsnModel;
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
	public String insertUserData(Model model, SsnMasterEntity ssnMasterEntiry, SsnModel ssnModel) {
		model.addAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
		gendersList(model);
		ssaServiceImpl.insertUserData(ssnMasterEntiry);
		return appProperties.getUserRegistration();
	}

	@RequestMapping("/getStatesList")
	public String getStatesList(Model model, StatesMasterEntity statesMasterEntity) {

		Iterable statesList = new ArrayList();
		statesList = ssaServiceImpl.getStatesList(statesMasterEntity);
		model.addAttribute("list", statesList);
		return "statesList";
	}

}
