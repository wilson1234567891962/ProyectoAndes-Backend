package com.co.andes.management.utils;

import com.co.andes.management.utils.exception.AndesException;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

public class UtilsTest {

    @Test(expected = NullPointerException.class)
    public void checkJWTWithException() throws AndesException {
        Utils.checkToken("mkyong");
    }
}
