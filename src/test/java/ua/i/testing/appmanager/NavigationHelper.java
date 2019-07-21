package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * created by FAMILY 21.07.2019
 */

public class NavigationHelper {
    ChromeDriver driver;

    public void goToDrafts() {
        driver.findElement(By.xpath("//ul[@class='list_underlined']/li[3]/a")).click();
    }
}
