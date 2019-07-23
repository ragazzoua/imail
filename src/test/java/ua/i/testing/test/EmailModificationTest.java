package ua.i.testing.test;

import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 23.07.2019
 */

public class EmailModificationTest extends TestBase {

    @Test
    public void emailModificationTest() {
        app.getNavigationHelper().goToDrafts();
        app.getGroupHelper().initEmailModification();
        app.getGroupHelper().fillEmailForm(new EmailData("to@ukr.net", "subject", "text"));
        app.getGroupHelper().submitEmailCreation();
        app.getNavigationHelper().goToDrafts();
    }
}
