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

    private final NavigationHelper navigationHelper = new NavigationHelper();
    private GroupHelper groupHelper;

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
        navigationHelper.driver = new ChromeDriver();
        navigationHelper.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navigationHelper.driver.manage().window().maximize();
        navigationHelper.driver.get("https://www.i.ua/");
        groupHelper = new GroupHelper(navigationHelper.driver);
        login("ittest2", "337774a");
    }

    private void login(String username, String password) {
        navigationHelper.driver.findElement(By.name("login")).click();
        navigationHelper.driver.findElement(By.name("login")).clear();
        navigationHelper.driver.findElement(By.name("login")).sendKeys(username);
        navigationHelper.driver.findElement(By.name("pass")).click();
        navigationHelper.driver.findElement(By.name("pass")).clear();
        navigationHelper.driver.findElement(By.name("pass")).sendKeys(password);
        navigationHelper.driver.findElement(By.xpath("//input[@type='submit' and @value='Войти']")).click();
    }

    public void stop() {
        navigationHelper.driver.quit();
    }

    public void acceptAlert() {
        navigationHelper.driver.switchTo().alert().accept();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
