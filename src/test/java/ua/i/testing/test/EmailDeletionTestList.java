package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.List;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTestList extends TestBase {

    @Test
    public void emailDeletionTest() {
        app.getNavigationHelper().goToDrafts();
        if (!app.getGroupHelper().isThereDraft()) {
            app.getGroupHelper().createDraft(new EmailData("to@ukr.net", null, "text"));
        }
        List<EmailData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectEmail(before.size() - 1);
        app.getGroupHelper().deleteSelectedEmails();
        app.acceptAlert();
        app.getNavigationHelper().goToDrafts();
        List<EmailData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size()-1);
        for (int i=0; i < after.size(); i++){
            Assert.assertEquals(before.get(i), after.get(i));
        }

    }

}
