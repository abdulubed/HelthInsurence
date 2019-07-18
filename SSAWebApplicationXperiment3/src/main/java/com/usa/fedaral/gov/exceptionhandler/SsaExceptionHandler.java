package com.usa.fedaral.gov.exceptionhandler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usa.fedaral.gov.config.SsaRestError;
import com.usa.fedaral.gov.exception.SsaRestException;
import com.usa.fedaral.gov.exception.SsaWebException;
import com.usa.fedaral.gov.properties.Applicationproperties;


@ControllerAdvice
public class SsaExceptionHandler {
	@Autowired
	private Applicationproperties applicationProperties;

	@ExceptionHandler(SsaWebException.class)
	public String ssaWebException(Model model) {
		String msg =applicationProperties.getException().get("ssaweebexcep");
		System.out.println(msg);
		model.addAttribute("err",msg);
		return "exception";
	}
	@ExceptionHandler(SsaRestException.class)
	public ResponseEntity<SsaRestError> ssaRestException() {
		SsaRestError err=new SsaRestError();
		err.setStatuscode(HttpStatus.BAD_REQUEST.value());
		err.setMsg(applicationProperties.getException().get("ssarestexcep"));
		//System.out.println(err.getMsg());
		err.setDate(new Date());
		System.out.println("time is :"+new Date());
		return new ResponseEntity<SsaRestError>(err, HttpStatus.BAD_REQUEST);
	}
	
}
