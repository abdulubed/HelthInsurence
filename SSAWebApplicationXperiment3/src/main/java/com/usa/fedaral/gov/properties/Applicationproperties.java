package com.usa.fedaral.gov.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ssa")
public class Applicationproperties {

	private String enrollsuccess;
	private String enrollfailure;
	private String msg;
	private String formAtr;
	private Map<String, String> exception = new HashMap<>();
	private Map<String, String> update = new HashMap<>();
	private Map<String, String> jsp = new HashMap<>();

	public Map<String, String> getJsp() {
		return jsp;
	}

	public void setJsp(Map<String, String> jsp) {
		this.jsp = jsp;
	}

	public String getFormAtr() {
		return formAtr;
	}

	public void setFormAtr(String formAtr) {
		this.formAtr = formAtr;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, String> getUpdate() {
		return update;
	}

	public void setUpdate(Map<String, String> update) {
		this.update = update;
	}

	public String getEnrollsuccess() {
		return enrollsuccess;
	}

	public void setEnrollsuccess(String enrollsuccess) {
		this.enrollsuccess = enrollsuccess;
	}

	public String getEnrollfailure() {
		return enrollfailure;
	}

	public void setEnrollfailure(String enrollfailure) {
		this.enrollfailure = enrollfailure;
	}

	public Map<String, String> getException() {
		return exception;
	}

	public void setException(Map<String, String> exception) {
		this.exception = exception;
	}
	

	@Override
	public String toString() {
		return "Applicationproperties [enrollsuccess=" + enrollsuccess + ", enrollfailure=" + enrollfailure + ", msg="
				+ msg + ", formAtr=" + formAtr + ", exception=" + exception + ", update=" + update + ", jsp=" + jsp
				+ "]";
	}
	

}
