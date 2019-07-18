package ua.i.testing;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }

    @Test
    public void emailCreationTest() {
        driver.get("https://www.i.ua/");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("ittest2");
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("337774a");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Войти']")).click();
        driver.findElement(By.xpath("//li[@class='new'][1]")).click();
        driver.findElement(By.xpath("//p[@class='make_message']/a")).click();
        driver.findElement(By.xpath("//textarea[@id='to']")).click();
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys("to@ukr.net");
        driver.findElement(By.xpath("//input[@name='subject']")).click();
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("subject");
        driver.findElement(By.xpath("//textarea[@id='text']")).click();
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys("text");
        driver.findElement(By.xpath("//input[@name='save_in_drafts']")).click();
        driver.findElement(By.xpath("//li[@class='new'][2]")).click();

    }
}
