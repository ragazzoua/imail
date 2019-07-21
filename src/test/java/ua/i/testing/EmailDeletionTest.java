package ua.i.testing;

import org.testng.annotations.Test;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTest extends TestBase {

    @Test
    public void emailDeletionTest(){
        app.goToDrafts();
        app.selectEmail();
        app.deleteSelectedEmails();
        app.acceptAlert();
        app.goToDrafts();

    }

}
