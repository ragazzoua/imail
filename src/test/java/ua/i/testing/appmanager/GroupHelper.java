package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.i.testing.model.EmailData;

import java.util.ArrayList;
import java.util.List;

/**
 * created by FAMILY 21.07.2019
 */

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
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

    public void selectEmail(int index) {
        driver.findElements(By.xpath("//form[@name='aform']//input[@type='checkbox']")).get(index).click();
    }

    public void initEmailModification(int index) {
        driver.findElements(By.xpath("//div[@class='row new']")).get(index).click();
    }

    public void returnToDrafts() {
        click(By.xpath("//ul[@class='list_underlined']/li[3]/a"));
    }

    public void createDraft(EmailData draft) {
        initEmailCreation();
        fillEmailForm(draft);
        submitEmailCreation();
        returnToDrafts();
    }

    public boolean isThereDraft() {
        return isElementPresent(By.xpath("//form[@name='aform']//input[@type='checkbox']"));
    }

    public int getGroupCount() {
        return driver.findElements(By.xpath("//form[@name='aform']//div[@class='row new']//input[@type='checkbox']")).size();
    }

    public List<EmailData> getGroupList() {
        List<EmailData> emails = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='frm']"));
        for (WebElement element: elements){
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            EmailData emailData = new EmailData(id, name,null,null);
            emails.add(emailData);

        }
        return emails;
    }
}
