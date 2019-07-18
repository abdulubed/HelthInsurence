package com.usa.fedaral.gov.ssa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usa.fedaral.gov.ssa.service.SsaServiceImpl;


@RestController
@RequestMapping("/restValidation")
public class SsnRestController {
	

	@Autowired
	private SsaServiceImpl ssaServiceImpl;

	@GetMapping(value = "/state", produces = { "application/json" })
	public String getStatesById(@RequestHeader("ssnNumber") Long ssnNumber) {
		String stateName = ssaServiceImpl.getStateNameById(ssnNumber);
		System.out.println(stateName);
		 //return Response.status(200).entity(stateName).build();		
		return stateName;
		

		
	}
}
