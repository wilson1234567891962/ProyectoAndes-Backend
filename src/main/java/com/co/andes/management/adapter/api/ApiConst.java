package com.co.andes.management.adapter.api;
import org.apache.log4j.Logger;
import org.springframework.core.env.ConfigurableEnvironment;

public class ApiConst {

    final static Logger logger = Logger.getLogger(ApiConst.class);
    
	protected ApiConst() {
		super();
	}

	public static final String LOGIN_PATH = "/ANDES";
	public static final String REPORT_FILE = "REPORTERIA.xlsx";
	public static final String REPORT_FILE_ORIGINAL = "Reporte_Diario.xlsx";
	public static final String SWAGGER_PATH = "com.co.andes.login.management";

	public static ConfigurableEnvironment CONFIGURABLE_PROPERTIES;
	public static String DEFAULT_IMAGE = "";
}