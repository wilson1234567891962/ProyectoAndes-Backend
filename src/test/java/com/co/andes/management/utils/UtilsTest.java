package com.co.andes.management.utils;

import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.token.JwtUtils;
import org.junit.Test;

public class UtilsTest {

    @Test(expected = AndesException.class)
    public void checkJWTWithException() throws AndesException {
        Utils.checkToken("mkyong");
    }

    @Test()
    public void checkTheJWTWhenItIsValid() throws AndesException {
        Utils.checkToken("eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzkwOTIwNzQsInN1YiI6IiIsImV4cCI6MTY3OTIxMjA3NH0.2QsarS_RcGN_Y4-2MEr0POMFZ0SgiO5-OMsAuP0-yR8");
    }
}
