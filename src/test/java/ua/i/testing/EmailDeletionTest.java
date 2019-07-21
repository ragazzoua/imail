package ua.i.testing;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTest extends TestBase {

    @Test
    public void emailDeletionTest(){
        goToDrafts();
        selectEmail();
        deleteSelectedEmails();
        acceptAlert();
        goToDrafts();

    }

}
