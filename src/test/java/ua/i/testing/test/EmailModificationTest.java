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
        app.goTo().drafts();
        if (!app.group().isThereDraft()) {
            app.group().create(new EmailData("to@ukr.net", null, "text"));
        }
        int before = app.group().getGroupCount();
        app.group().initEmailModification(before - 1);
        app.group().fillEmailForm(new EmailData("to1@ukr.net", "subject", "text1"));
        app.group().submitEmailCreation();
        app.goTo().drafts();
        int after = app.group().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
