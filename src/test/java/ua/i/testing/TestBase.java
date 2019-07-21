package ua.i.testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * created by FAMILY 21.07.2019
 */

public class TestBase extends ApplicationManager {

    @BeforeMethod
    public void setup() throws Exception {
        init();
    }

    @AfterMethod
    public void tearDown() {
        stop();
    }

}
