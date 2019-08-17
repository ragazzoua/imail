package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.List;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTest extends TestBase {

    @Test
    public void emailCreationTest() {
        app.goTo().drafts();
        List<EmailData> before = app.group().list();
        EmailData emailData = new EmailData().withEmailAddress("dfsad@ukr.net");
        app.group().create(emailData);
        List<EmailData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size() + 1);


    }

}
