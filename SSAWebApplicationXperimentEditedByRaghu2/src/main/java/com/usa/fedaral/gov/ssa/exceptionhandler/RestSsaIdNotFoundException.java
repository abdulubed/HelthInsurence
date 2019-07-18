package com.usa.fedaral.gov.ssa.exceptionhandler;


public class RestSsaIdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RestSsaIdNotFoundException(String exceptionMsg)
	{
		super(exceptionMsg);
	}
	
}