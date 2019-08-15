package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.Comparator;
import java.util.List;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTestLambda extends TestBase {

    @Test
    public void emailCreationTest() {
        app.getNavigationHelper().goToDrafts();
        List<EmailData> before = app.getGroupHelper().getGroupList();
        EmailData emailData = new EmailData("to@ukr.net", null, "text");
        app.getGroupHelper().createDraft(emailData);
        List<EmailData> after = app.getGroupHelper().getGroupList();

        int max = 0;
        for (EmailData data: after){
            if (data.getId().equals(String.valueOf(max)))
            max = Integer.parseInt(data.getId());
        }

        Comparator<? super EmailData> byId = (o1, o2) -> Integer.compare(Integer.parseInt(o1.getId()), Integer.parseInt(o2.getId()));
        int max1 = Integer.parseInt(after.stream().max(byId).get().getId());

        emailData.setId(String.valueOf(max1));
        before.add(emailData);

        Assert.assertEquals(after.size(), before.size() + 1);


    }

}
