package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 21.07.2019
 */

public class GroupHelper extends HelperBase {

    public GroupHelper(ChromeDriver driver) {
        super(driver);
    }

    public void submitEmailCreation() {
        click(By.xpath("//input[@name='save_in_drafts']"));
    }

    public void fillEmailForm(EmailData emailData) {
        type(By.xpath("//textarea[@id='to']"), emailData.getEmailAddress());
        type(By.xpath("//input[@name='subject']"), emailData.getSubject());
        type(By.xpath("//textarea[@id='text']"), emailData.getEmailText());
    }

    public void initEmailCreation() {
        click(By.xpath("//p[@class='make_message']/a"));
    }

    public void deleteSelectedEmails() {
        click(By.xpath("//div[@id='fieldset1']//span[@class='button l_r del']"));
    }

    public void selectEmail() {
        click(By.xpath("//form[@name='aform']//input[@type='checkbox']"));
    }

    public void initEmailModification() {
        click(By.xpath("//span[@class='frm']"));
    }
}
