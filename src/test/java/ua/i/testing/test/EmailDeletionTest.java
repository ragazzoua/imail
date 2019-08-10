package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTest extends TestBase {

    @Test
    public void emailDeletionTest() {
        app.getNavigationHelper().goToDrafts();
        if (!app.getGroupHelper().isThereDraft()) {
            app.getGroupHelper().createDraft(new EmailData("to@ukr.net", null, "text"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectEmail(before - 1);
        app.getGroupHelper().deleteSelectedEmails();
        app.acceptAlert();
        app.getNavigationHelper().goToDrafts();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);

    }

}
