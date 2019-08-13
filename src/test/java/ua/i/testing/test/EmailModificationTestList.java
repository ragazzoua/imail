package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.ArrayList;
import java.util.List;

/**
 * created by FAMILY 23.07.2019
 */

public class EmailModificationTestList extends TestBase {

    @Test
    public void emailModificationTest() {
        app.getNavigationHelper().goToDrafts();
        if (!app.getGroupHelper().isThereDraft()) {
            app.getGroupHelper().createDraft(new EmailData("to@ukr.net", null, null));
        }
        List<EmailData> before= app.getGroupHelper().getGroupList();
        app.getGroupHelper().initEmailModification(before.size() - 1);
        app.getGroupHelper().fillEmailForm(new EmailData("to1@ukr.net", "subject", "text1"));
        app.getGroupHelper().submitEmailCreation();
        app.getNavigationHelper().goToDrafts();
        List<EmailData> after= app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
