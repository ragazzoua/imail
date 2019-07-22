package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * created by FAMILY 21.07.2019
 */

public class SessionHelper extends HelperBase {
    ChromeDriver driver;

    public SessionHelper(ChromeDriver driver) {
        super(driver);

    }

    public void login(String username, String password) {
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit' and @value='Войти']")).click();
    }
}
