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
        if (!app.getGroupHelper().isThereDraft()){
            app.getGroupHelper().createDraft(new EmailData("to@ukr.net", null, "text"));
        }
        app.getGroupHelper().initEmailModification();
        app.getGroupHelper().fillEmailForm(new EmailData("to1@ukr.net", "subject", "text1"));
        app.getGroupHelper().submitEmailCreation();
        app.getNavigationHelper().goToDrafts();
    }
}
