package com.co.andes.management.utils;

import com.co.andes.management.utils.exception.AndesException;
import org.junit.Test;

public class UtilsTest {

    @Test(expected = AndesException.class)
    public void checkJWTWithException() throws AndesException {
        Utils.checkToken("mkyong");
    }
}
