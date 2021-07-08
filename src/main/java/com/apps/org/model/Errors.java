package com.apps.org.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Errors {

	@JsonProperty("employeeResponse")
	private EmployeeIOModel employeeResponse;
	
	private int errorCode;
	private String message;
	private Throwable cause;
	
	public EmployeeIOModel getEmployeeResponse() {
		return employeeResponse;
	}
	public void setEmployeeResponse(EmployeeIOModel employeeResponse) {
		this.employeeResponse = employeeResponse;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable throwable) {
		this.cause = throwable;
	}
	
}
