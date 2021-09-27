package com.example.demo.exception;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private String details;
	private Date timesatmp;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public Date getTimesatmp() {
		return timesatmp;
	}


	public void setTimesatmp(Date timesatmp) {
		this.timesatmp = timesatmp;
	}

	

	public ExceptionResponse(String message, String details, Date timesatmp) {
		super();
		this.message = message;
		this.details = details;
		this.timesatmp = timesatmp;
	}


	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", details=" + details + ", timesatmp=" + timesatmp + "]";
	}
	
	
}
