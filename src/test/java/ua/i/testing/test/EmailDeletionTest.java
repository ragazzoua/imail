package ua.i.testing.test;

import org.testng.annotations.Test;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTest extends TestBase {

    @Test
    public void emailDeletionTest(){
        app.getNavigationHelper().goToDrafts();
        app.getGroupHelper().selectEmail();
        app.getGroupHelper().deleteSelectedEmails();
        app.acceptAlert();
        app.getNavigationHelper().goToDrafts();

    }

}
