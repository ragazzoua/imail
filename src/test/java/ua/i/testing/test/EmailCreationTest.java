package ua.i.testing.test;

import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

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
