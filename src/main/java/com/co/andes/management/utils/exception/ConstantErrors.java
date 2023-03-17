package com.co.andes.management.utils.exception;

import java.util.HashMap;

import org.apache.log4j.Logger;


public class ConstantErrors {

	public static final HashMap<String, AndesError> ERRORS_STATES = new HashMap<>();
	final static Logger logger = Logger.getLogger(ConstantErrors.class);
	
	static {
		ERRORS_STATES.put(AndesErrorEnum.SUCCESS_TRANSACTION.getCode(), new AndesError(AndesErrorEnum.SUCCESS_TRANSACTION.getCode(),"SU transacción  fue procesada con exito."));

		ERRORS_STATES.put(AndesErrorEnum.GENERIC_ERROR.getCode(), new AndesError(AndesErrorEnum.GENERIC_ERROR.getCode(),"Se presentaron problemas tecnicos por favor intente nuevamente."));

		ERRORS_STATES.put(AndesErrorEnum.LOGIN_PASSWORD_AND_USER_CONSULTING.getCode(), new AndesError(AndesErrorEnum.LOGIN_PASSWORD_AND_USER_CONSULTING.getCode(),"Por favor revise el usuario o clave digitado."));

		ERRORS_STATES.put(AndesErrorEnum.LOGIN_PASSWORD_AND_USER_IS_NOT_ACTIVE.getCode(), new AndesError(AndesErrorEnum.LOGIN_PASSWORD_AND_USER_IS_NOT_ACTIVE.getCode(),"Por favor contacte al administrador para que revise su perfil."));

		ERRORS_STATES.put(AndesErrorEnum.DATABASE_OBJECT_CONSULTING.getCode(), new AndesError(AndesErrorEnum.DATABASE_OBJECT_CONSULTING.getCode(),"No tenemos registro asociados para esta solicitud."));

		ERRORS_STATES.put(AndesErrorEnum.REGISTER_PASSWORD_AND_USER_CONSULTING.getCode(), new AndesError(AndesErrorEnum.REGISTER_PASSWORD_AND_USER_CONSULTING.getCode(),"Se presentaron problemas con los datos enviados, por favor contacte al administrador de la plataforma"));
	}
}
