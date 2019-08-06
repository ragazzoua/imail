package ua.i.testing.test;

import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTest extends TestBase {

    @Test
    public void emailDeletionTest(){
        app.getNavigationHelper().goToDrafts();
        app.getGroupHelper().selectEmail();
        if (!app.getGroupHelper().isThereDraft()){
            app.getGroupHelper().createDraft(new EmailData("to@ukr.net", null, "text"));
        }
        app.getGroupHelper().deleteSelectedEmails();
        app.acceptAlert();
        app.getNavigationHelper().goToDrafts();

    }

}
