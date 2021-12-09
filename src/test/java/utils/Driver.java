package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


public class Driver {

    private static WebDriver driver;

    @BeforeTest
    public static WebDriver setDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void startUrl() {
        WebDriver driver=Driver.setDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        //  driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;

    }


}
