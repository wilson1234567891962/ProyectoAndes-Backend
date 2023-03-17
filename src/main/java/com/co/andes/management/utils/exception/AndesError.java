package com.co.andes.management.utils.exception;

import org.apache.log4j.Logger;

public class AndesError {
	final static Logger logger = Logger.getLogger(AndesError.class);
	private String code;
	private String message;

	public AndesError(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
