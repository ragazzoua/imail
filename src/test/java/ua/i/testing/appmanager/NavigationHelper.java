package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * created by FAMILY 21.07.2019
 */

public class NavigationHelper extends HelperBase{


    public NavigationHelper(ChromeDriver driver) {
        super(driver);

    }

    public void goToDrafts() {
        click(By.xpath("//ul[@class='list_underlined']/li[3]/a"));
    }
}
