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
        app.getNavigationHelper().goToDrafts();
        if (!app.getGroupHelper().isThereDraft()) {
            app.getGroupHelper().createDraft(new EmailData("to0000@ukr.net", null, null));
        }
    }

    @Test(enabled = false)
    public void emailModificationTest() {
        List<EmailData> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        EmailData data = new EmailData(before.get(index).getId(), "to2@ukr.net", null, null);
        app.getGroupHelper().modifyGroup(index, data);
        List<EmailData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(data);
        Comparator<? super EmailData> byId = (g1, g2) -> Integer.compare(Integer.parseInt(g1.getId()), Integer.parseInt(g2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
