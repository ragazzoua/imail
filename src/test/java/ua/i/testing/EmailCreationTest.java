package ua.i.testing;

import org.testng.annotations.Test;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTest extends TestBase {

    @Test
    public void emailCreationTest() {
        app.goToDrafts();
        app.initEmailCreation();
        app.fillEmailForm(new EmailData("to@ukr.net", "subject", "text"));
        app.submitEmailCreation();
        app.goToDrafts();

    }

}
