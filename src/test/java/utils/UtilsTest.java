package utils;

import com.co.andes.management.utils.Utils;
import com.co.andes.management.utils.exception.AndesException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UtilsTest {

    @Test(expected = AndesException.class)
    public void checkJWTWithException() throws AndesException {
        Utils.checkToken("mkyong");
    }
}
