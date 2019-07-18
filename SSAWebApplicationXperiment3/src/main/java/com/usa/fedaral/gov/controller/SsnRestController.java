package com.usa.fedaral.gov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usa.fedaral.gov.services.SsnService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="this is SsaRest SsnRestController")
public class SsnRestController {
	
	@Autowired
	private SsnService ssnservice;

	/*
	 * this is getStateBySsn to get Record from DB By SSn No
	 */
	@ApiOperation(value="find state by ssnno ",produces=MediaType.TEXT_PLAIN_VALUE)
	@GetMapping("findstatebyssn/{ssn}")
	public String getStateBySsn(@PathVariable("ssn") int ssn) {
		String statename = ssnservice.findStateBySsn(ssn);
		return statename;
	}
}
