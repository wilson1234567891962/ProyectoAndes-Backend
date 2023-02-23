package com.co.andes.management.utils;

import com.co.andes.management.utils.exception.AndesErrorEnum;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.token.JwtUtils;

import java.text.DateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class Utils {

    public static void checkToken(String token) throws AndesException {
        if (JwtUtils.decodeJWTAnExtend(token).isEmpty()) {
            throw new AndesException(AndesErrorEnum.GENERIC_ERROR.getCode());
        }
    }
}
