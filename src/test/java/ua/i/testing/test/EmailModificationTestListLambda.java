package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.*;

/**
 * created by FAMILY 23.07.2019
 */

public class EmailModificationTestListLambda extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().drafts();
        if (app.group().list().size() == 0) {
            app.group().create(new EmailData("to0000@ukr.net", null, null));
        }
    }

    @Test(enabled = false)
    public void emailModificationTest() {
        List<EmailData> before = app.group().list();
        int index = before.size() - 1;
        EmailData data = new EmailData(before.get(index).getId(), "to2@ukr.net", null, null);
        app.group().modify(index, data);
        List<EmailData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(data);
        Comparator<? super EmailData> byId = (g1, g2) -> Integer.compare(Integer.parseInt(g1.getId()), Integer.parseInt(g2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
