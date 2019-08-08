package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTest extends TestBase {

    @Test
    public void emailCreationTest() {
        app.getNavigationHelper().goToDrafts();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createDraft(new EmailData("to@ukr.net", null, "text"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);


    }

}
