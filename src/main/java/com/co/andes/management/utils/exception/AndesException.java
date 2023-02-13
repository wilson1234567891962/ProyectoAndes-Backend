package com.co.andes.management.utils.exception;

import org.apache.log4j.Logger;

public class AndesException extends Exception {

    final static Logger logger = Logger.getLogger(AndesException.class);
    private static final long serialVersionUID = 4607469051774932616L;

    public AndesException(String code) {
        super(code);
    }
}
