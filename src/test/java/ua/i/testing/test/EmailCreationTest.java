package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.HashSet;
import java.util.List;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTest extends TestBase {

    @Test
    public void emailCreationTest() {
        app.getNavigationHelper().goToDrafts();
        List<EmailData> before = app.getGroupHelper().getGroupList();
        EmailData emailData = new EmailData("to@ukr.net", null, "text");
        app.getGroupHelper().createDraft(emailData);
        List<EmailData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() + 1);


    }

}
