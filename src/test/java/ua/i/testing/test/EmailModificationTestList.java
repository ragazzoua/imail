package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.HashSet;
import java.util.List;

/**
 * created by FAMILY 23.07.2019
 */

public class EmailModificationTestList extends TestBase {

    @Test
    public void emailModificationTest() {
        app.goTo().drafts();
        if (!app.group().isThereDraft()) {
            app.group().create(new EmailData("to0000@ukr.net", null, null));
        }
        List<EmailData> before= app.group().list();
        app.group().initEmailModification(before.size() - 1);

        EmailData data = new EmailData(before.get(before.size() -1).getId(),"to2@ukr.net", null, null);

        app.group().fillEmailForm(data);
        app.group().submitEmailCreation();
        app.goTo().drafts();
        List<EmailData> after= app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(data);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}
