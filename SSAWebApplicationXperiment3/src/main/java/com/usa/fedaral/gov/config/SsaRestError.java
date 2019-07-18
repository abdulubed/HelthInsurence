package com.usa.fedaral.gov.config;

import java.util.Date;

public class SsaRestError {
 private int statuscode;
 private String msg;
 private Date date;
public int getStatuscode() {
	return statuscode;
}
public void setStatuscode(int statuscode) {
	this.statuscode = statuscode;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "SsaRestError [statuscode=" + statuscode + ", msg=" + msg + ", date=" + date + "]";
}
 
}
