package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.*;

/**
 * created by FAMILY 23.07.2019
 */

public class EmailModificationTestListLambda extends TestBase {

    @Test
    public void emailModificationTest() {
        app.getNavigationHelper().goToDrafts();
        if (!app.getGroupHelper().isThereDraft()) {
            app.getGroupHelper().createDraft(new EmailData("to0000@ukr.net", null, null));
        }
        List<EmailData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().initEmailModification(before.size() - 1);

        EmailData data = new EmailData(before.get(before.size() - 1).getId(), "to2@ukr.net", null, null);

        app.getGroupHelper().fillEmailForm(data);
        app.getGroupHelper().submitEmailCreation();
        app.getNavigationHelper().goToDrafts();
        List<EmailData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(data);
        Comparator<? super EmailData> byId = (g1, g2) -> Integer.compare(Integer.parseInt(g1.getId()), Integer.parseInt(g2.getId()));
        before.sort(byId);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}
