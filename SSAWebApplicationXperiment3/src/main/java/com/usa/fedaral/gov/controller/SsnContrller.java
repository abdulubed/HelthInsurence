package com.usa.fedaral.gov.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.fedaral.gov.exception.SsaWebException;
import com.usa.fedaral.gov.models.UsStatesModel;
import com.usa.fedaral.gov.models.ssnfrommodel;
import com.usa.fedaral.gov.properties.Applicationproperties;
import com.usa.fedaral.gov.services.SsnService;

@Controller
public class SsnContrller {

	private static final Logger log = LoggerFactory.getLogger(SsnContrller.class);

	@Autowired
	private SsnService ssnservice;
	@Autowired
	private Applicationproperties applicationProperties;

	/*
	 * This Method is to Luanch Ssn Form Page
	 */
	@RequestMapping("/")
	public String displaySsnFormPage(Model model) throws SsaWebException {
		log.info("displaySsnFormPage is started");
		int a = 0;
		System.out.println(applicationProperties.getEnrollsuccess());
		System.out.println(applicationProperties.getEnrollfailure());
		ssnfrommodel sf = new ssnfrommodel();
		try {
			a = 1 / 1;
			System.out.println(a);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SsaWebException();

		}
		model.addAttribute(applicationProperties.getFormAtr(), sf);
		genderDetails(model);
		usStatesDetails(model);
		log.debug("displaySsnFormPage is ended");

		return applicationProperties.getJsp().get("formlaunch");
	}

	/*
	 * This Method is to Get Gender
	 */
	public void genderDetails(Model model) {
		log.info("genderDetails method is started");
		List<String> al = new ArrayList();
		al.add("male");
		al.add("fe-male");
		for (String string : al) {
			System.out.println(al);
		}
		model.addAttribute("gender", al);
		log.info("genderDetails method is ended");
	}

	/*
	 * This Method is to retrieve All States From Db
	 */
	public void usStatesDetails(Model model) {
		log.info("usStatesDetails method is started");
		/*List<UsStatesModel> lm = ssnservice.getstates();
		List<String> lm1 = new ArrayList();
		for (UsStatesModel usStatesModel : lm) {
			String statename = usStatesModel.getStateName();
			lm1.add(statename);
		}*/
		
		
		List<String> al = new ArrayList();
		al.add("new york");
		al.add("new jersey");
		model.addAttribute("states", al);
		log.info("usStatesDetails method is ended");
	}

	/*
	 * This Method is to Sava The Ssn Form Data
	 */
	@RequestMapping(value = "/formurl", method = RequestMethod.POST)
	public String saveSsnFormData(@ModelAttribute("formAtr") @Valid ssnfrommodel ssnmodel, BindingResult result,
			Model model) {
		String msg = null;
		log.debug("saveSsnFormData method is started");
		if (result.hasErrors()) {
			genderDetails(model);
			usStatesDetails(model);
			System.out.println("-------------------------------------------------------------");
			return applicationProperties.getJsp().get("formlaunch");
		}
		boolean res = ssnservice.insertSsnEnoll(ssnmodel);
		if (res == true) {
			model.addAttribute(applicationProperties.getMsg(), applicationProperties.getEnrollsuccess());

		} else {
			model.addAttribute(applicationProperties.getMsg(), applicationProperties.getEnrollfailure());
		}
		genderDetails(model);
		usStatesDetails(model);
		log.debug("saveSsnFormData method is ended");
		return applicationProperties.getJsp().get("formlaunch");
	}

	/*
	 * This Method is To Get All Records From DB
	 */
	@GetMapping("/getallSsnRecords")
	public String getAllSsnRecords(Model model) {
		log.debug("getAllSsnRecords method is started");
		List<ssnfrommodel> lsm = ssnservice.retriveAllSsnRecords();
		model.addAttribute("list", lsm);
		log.debug("getAllSsnRecords method is ended");
		return applicationProperties.getJsp().get("viewrecords");
	}

	/*
	 * This Method is To Get Ssn Record By SsnNo
	 */
	@GetMapping("/editssnrecord/{ssnno}")
	public String getSsnRecordsById(@PathVariable("ssnno") int ssnno, Model model) {
		log.debug("updateSsnRecordsById method is started");
		System.out.println("ssn no is ::" + ssnno);
		ssnfrommodel ssnmodel = new ssnfrommodel();
		ssnmodel = ssnservice.updateSsnRecordById(ssnno);
		System.out.println(ssnmodel.toString());
		genderDetails(model);
		usStatesDetails(model);
		model.addAttribute("ssnno", ssnno);
		model.addAttribute("updateAtr", ssnmodel);
		log.debug("updateSsnRecordsById method is ended");
		return applicationProperties.getJsp().get("update");
	}

	/*
	 * This Method is To Update The SsnFormRecord
	 */
	@RequestMapping(value = "/updateurl", method = RequestMethod.POST)
	public String updateSsnFormData(@Valid @ModelAttribute("updateAtr") ssnfrommodel ssnmodel, Model model,
			BindingResult result) {
		log.debug("saveSsnFormData method is started");
		/*
		 * if(result.hasErrors()) { return "ssnFormlaunch"; }
		 */
		// System.out.println(ssnno);
		String msg = null;
		boolean res = ssnservice.updateSsnEnoll(ssnmodel);
		if (res == true) {
			model.addAttribute("msg", applicationProperties.getUpdate().get("success"));
		} else {
			model.addAttribute("msg", applicationProperties.getUpdate().get("fail"));
		}
		log.debug("saveSsnFormData method is ended");
		return applicationProperties.getJsp().get("update");
	}

}
