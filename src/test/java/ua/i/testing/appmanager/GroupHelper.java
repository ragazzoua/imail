package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 21.07.2019
 */

public class GroupHelper {
    ChromeDriver driver;

    public void submitEmailCreation() {
        driver.findElement(By.xpath("//input[@name='save_in_drafts']")).click();
    }

    public void fillEmailForm(EmailData emailData) {
        driver.findElement(By.xpath("//textarea[@id='to']")).click();
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys(emailData.getEmailAddress());
        driver.findElement(By.xpath("//input[@name='subject']")).click();
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(emailData.getSubject());
        driver.findElement(By.xpath("//textarea[@id='text']")).click();
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys(emailData.getEmailText());
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
