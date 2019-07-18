package com.usa.fedaral.gov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SsaRestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//private static final Long serialVersionUID=1L;

	public SsaRestException(String exception) {
		
		super(exception);
		System.out.println(exception);
	}

}
