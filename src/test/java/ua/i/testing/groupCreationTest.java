package ua.i.testing;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * created by FAMILY 18.07.2019
 */

public class groupCreationTest {

    ChromeDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.i.ua/");
        login();
    }

    private void login() {
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("ittest2");
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("337774a");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Войти']")).click();
    }

    @Test
    public void emailCreationTest() {
        driver.findElement(By.xpath("//ul[@class='list_underlined']/li[3]/a")).click();
        driver.findElement(By.xpath("//p[@class='make_message']/a")).click();
        driver.findElement(By.xpath("//textarea[@id='to']")).click();
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys("to@ukr.net");
        driver.findElement(By.xpath("//input[@name='subject']")).click();
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("subject");
        driver.findElement(By.xpath("//textarea[@id='text']")).click();
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys("text");
        driver.findElement(By.xpath("//input[@name='save_in_drafts']")).click();
        driver.findElement(By.xpath("//ul[@class='list_underlined']/li[3]/a")).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
