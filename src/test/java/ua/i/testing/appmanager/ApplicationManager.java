package ua.i.testing.appmanager;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * created by FAMILY 21.07.2019
 */

public class ApplicationManager {

    private final GroupHelper groupHelper = new GroupHelper();

    public static boolean isAlertPresent(FirefoxDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        groupHelper.driver = new ChromeDriver();
        groupHelper.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        groupHelper.driver.manage().window().maximize();
        groupHelper.driver.get("https://www.i.ua/");
        login("ittest2", "337774a");
    }

    private void login(String username, String password) {
        groupHelper.driver.findElement(By.name("login")).click();
        groupHelper.driver.findElement(By.name("login")).clear();
        groupHelper.driver.findElement(By.name("login")).sendKeys(username);
        groupHelper.driver.findElement(By.name("pass")).click();
        groupHelper.driver.findElement(By.name("pass")).clear();
        groupHelper.driver.findElement(By.name("pass")).sendKeys(password);
        groupHelper.driver.findElement(By.xpath("//input[@type='submit' and @value='Войти']")).click();
    }

    public void goToDrafts() {
        groupHelper.driver.findElement(By.xpath("//ul[@class='list_underlined']/li[3]/a")).click();
    }

    public void stop() {
        groupHelper.driver.quit();
    }

    public void acceptAlert(){
        groupHelper.driver.switchTo().alert().accept();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
