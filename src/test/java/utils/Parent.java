package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Parent {

    static WebDriverWait wait = new WebDriverWait(Driver.setDriver(), 5);

    public static void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void sendToElement(WebElement element, String key) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(key);
    }

    public void stop(int number) {
        try {
            Thread.sleep(1000 * number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
