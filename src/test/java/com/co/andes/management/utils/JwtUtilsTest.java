package com.co.andes.management.utils;
import com.co.andes.management.utils.exception.AndesException;
import com.co.andes.management.utils.token.JwtUtils;
import io.jsonwebtoken.Claims;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class JwtUtilsTest {

    @Test()
    public void checkNullCreatingToken() throws AndesException {
        assertNotNull(JwtUtils.createJWT("","", 1));
    }

    @Test()
    public void checkNullCreatingTokenWithProduct() throws AndesException {
        assertNotNull(JwtUtils.createJWT("","","",1));
    }

    @Test
    public void checkDecodeJWTWorkingFine() {
        String toDecodeJWT = JwtUtils.createJWT("","", 1);
        Claims decodeString = JwtUtils.decodeJWT(toDecodeJWT);
        assertNotNull(decodeString);
    }

    @Test
    public void checkStringDecodeJWTAnExtend() {
        String toDecodeJWT = JwtUtils.createJWT("","", 1);
        String decodeString = JwtUtils.decodeJWTAnExtend(toDecodeJWT);
        assertNotNull(decodeString);
    }
    
}
