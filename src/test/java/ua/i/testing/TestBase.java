package ua.i.testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * created by FAMILY 21.07.2019
 */

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setup() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}
