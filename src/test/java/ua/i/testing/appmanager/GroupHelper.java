package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 21.07.2019
 */

public class GroupHelper {
    private ChromeDriver driver;

    public GroupHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void submitEmailCreation() {
        driver.findElement(By.xpath("//input[@name='save_in_drafts']")).click();
    }

    public void fillEmailForm(EmailData emailData) {
        type(By.xpath("//textarea[@id='to']"), emailData.getEmailAddress());
        type(By.xpath("//input[@name='subject']"), emailData.getSubject());
        type(By.xpath("//textarea[@id='text']"), emailData.getEmailText());
    }

    private void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(text);
    }

    public void initEmailCreation() {
        driver.findElement(By.xpath("//p[@class='make_message']/a")).click();
    }

    public void deleteSelectedEmails() {
        driver.findElement(By.xpath("//div[@id='fieldset1']//span[@class='button l_r del']")).click();
    }

    public void selectEmail() {
        driver.findElement(By.xpath("//form[@name='aform']//input[@type='checkbox']")).click();
    }
}
