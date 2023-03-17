package com.co.andes.management.adapter.api;
import org.apache.log4j.Logger;
import org.springframework.core.env.ConfigurableEnvironment;

public class ApiConst {

    final static Logger logger = Logger.getLogger(ApiConst.class);
    
	protected ApiConst() {
		super();
	}

	public static final String LOGIN_PATH = "/ANDES";
	public static final String STORE_PATH = "/ANDES/STORE";
	public static final String ORDER_PATH = "/ANDES/ORDER";
	public static final String SWAGGER_PATH = "com.co.andes.login.management";
	public static final String URL_SERVICE = "https://andes-deploy.herokuapp.com/ANDES/message";

	public static ConfigurableEnvironment CONFIGURABLE_PROPERTIES;
	public static String DEFAULT_IMAGE = "";
}