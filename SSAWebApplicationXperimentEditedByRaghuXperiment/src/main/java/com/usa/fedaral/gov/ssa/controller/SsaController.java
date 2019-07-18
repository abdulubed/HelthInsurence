package com.usa.fedaral.gov.ssa.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping(path = "/displayForm", method = RequestMethod.GET)
	public String displayForm(Model model) {
		model.addAttribute("ssnModel", new SsnModel());
		initializerValues(model);
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
	public String insertUserData(RedirectAttributes redirectAttributes,
			@ModelAttribute("ssnModel") @Valid SsnModel ssnModel, BindingResult result) {

		// model.addAttribute(appProperties.getMessage(),
		// appProperties.getEnrollSuccess());

		if (result.hasErrors()) {
			// initializerValues(redirectAttributes);
			// return appProperties.getUserRegistration();
			return "redirect:/displayForm";
		}
		redirectAttributes.addFlashAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
		initializerValues(redirectAttributes);
		String ssnNumber = ssaServiceImpl.insertUserData(ssnModel);
		redirectAttributes.addFlashAttribute("ssnNumber", ssnNumber);
		// return appProperties.getUserRegistration();
		return "redirect:/displayForm";
	}

	public String initializerValues(Model model) {

		List list = ssaServiceImpl.getStatesList();
		model.addAttribute("statesList", list);
		List gendersList = new ArrayList();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("gendersList", gendersList);
		return appProperties.getUserRegistration();

	}

	@RequestMapping("/getAllSsnRecords")
	public String getallSsnRecords(Model model) {

		List<SsnModel> ssnRecords = ssaServiceImpl.getAllSsnRecords();
		
		
		/*
		 * List ssnNumbersList = new ArrayList(); for(SsnModel ssnNumbers : ssnRecords)
		 * { ssnNumbersList.add(ssnNumbers.getSsnNumber()); }
		 * 
		 * model.addAttribute("ssnNumberList", ssnNumbersList);
		 */
		
		/*
		 * List ssnNumberList = new ArrayList(); for(SsnModel ssnRecordsList :
		 * ssnRecords) {
		 * 
		 * Long ssnNumbersList = ssnRecordsList.getSsnNumber(); String
		 * stringSsnNumbersList = String.valueOf(ssnNumbersList);
		 * ssnNumberList.add(stringSsnNumbersList);
		 * 
		 * ssnNumberList.add(ssnRecordsList.getSsnNumber()); }
		 */
		model.addAttribute("ssnRecords", ssnRecords);
		//System.out.println(ssnNumberList);
		System.out.println(ssnRecords);

		return "getAllSsnRecords";

	}

	@RequestMapping("/stateName")
	public void getStateName(Long ssnNumber) {

		String stateName = ssaServiceImpl.getStateNameById(ssnNumber);
		System.out.println(stateName);

	}
	
	@RequestMapping(value = "/getPhoto/{ssnNumber}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("ssnNumber") Long ssnNumber) throws Exception {
		response.setContentType("image/jpeg");
		byte[] photo = ssaServiceImpl.getImageById(ssnNumber);
		InputStream inputStream = new ByteArrayInputStream(photo);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
}
	

