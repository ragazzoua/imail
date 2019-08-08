package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 23.07.2019
 */

public class EmailModificationTest extends TestBase {

    @Test
    public void emailModificationTest() {
        app.getNavigationHelper().goToDrafts();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getGroupHelper().isThereDraft()){
            app.getGroupHelper().createDraft(new EmailData("to@ukr.net", null, "text"));
        }
        app.getGroupHelper().initEmailModification(before-1);
        app.getGroupHelper().fillEmailForm(new EmailData("to1@ukr.net", "subject", "text1"));
        app.getGroupHelper().submitEmailCreation();
        app.getNavigationHelper().goToDrafts();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
