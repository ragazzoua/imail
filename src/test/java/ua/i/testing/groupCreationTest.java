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

public class groupCreationTest extends TestBase {

    @Test
    public void emailCreationTest() {
        goToDrafts();
        initEmailCreation();
        fillEmailForm(new EmailData("to@ukr.net", "subject", "text"));
        submitEmailCreation();
        goToDrafts();

    }

}
