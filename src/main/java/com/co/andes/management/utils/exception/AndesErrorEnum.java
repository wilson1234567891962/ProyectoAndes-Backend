package com.co.andes.management.utils.exception;
import org.apache.log4j.Logger;

public enum AndesErrorEnum {

    SUCCESS_TRANSACTION("TR-0000"),
    DATABASE_OBJECT_CONSULTING("DB-0000"),
    LOGIN_PASSWORD_AND_USER_CONSULTING("LG-0000"),
    LOGIN_PASSWORD_AND_USER_IS_NOT_ACTIVE("LG-0001"),
    REGISTER_PASSWORD_AND_USER_CONSULTING("RE-0000"),
    GENERIC_ERROR("EX-0000");

    final static Logger logger = Logger.getLogger(AndesErrorEnum.class);
    private String code;

    AndesErrorEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
