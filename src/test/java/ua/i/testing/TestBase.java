package ua.i.testing;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * created by FAMILY 21.07.2019
 */

public class TestBase {
    ChromeDriver driver;

    public static boolean isAlertPresent(FirefoxDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setup() throws Exception {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.i.ua/");
        login("ittest2", "337774a");
    }

    private void login(String username, String password) {
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit' and @value='Войти']")).click();
    }

    protected void submitEmailCreation() {
        driver.findElement(By.xpath("//input[@name='save_in_drafts']")).click();
    }

    protected void fillEmailForm(EmailData emailData) {
        driver.findElement(By.xpath("//textarea[@id='to']")).click();
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys(emailData.getEmailAddress());
        driver.findElement(By.xpath("//input[@name='subject']")).click();
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(emailData.getSubject());
        driver.findElement(By.xpath("//textarea[@id='text']")).click();
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys(emailData.getEmailText());
    }

    protected void initEmailCreation() {
        driver.findElement(By.xpath("//p[@class='make_message']/a")).click();
    }

    protected void goToDrafts() {
        driver.findElement(By.xpath("//ul[@class='list_underlined']/li[3]/a")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected void deleteSelectedEmails() {
        driver.findElement(By.xpath("//div[@id='fieldset1']//span[@class='button l_r del']")).click();
    }

    protected void selectEmail() {
        driver.findElement(By.xpath("//form[@name='aform']//input[@type='checkbox']")).click();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
}
