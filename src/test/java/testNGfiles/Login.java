package testNGfiles;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Driver;
import utils.Parent;

import java.util.Random;


public class Login extends Parent {


    @Test(dataProvider = "getData")
    void loginTest(String username, String password, boolean success) {
        Driver.startUrl();
        BaseElements bs = new BaseElements();
        sendToElement(bs.getUsername(), username);
        sendToElement(bs.getPassword(), password);
        clickElement(bs.getLocationList().get(new Random().nextInt(6)));
        clickElement(bs.getLoginButton());
//        try {
//            if (bs.getMyAccount().isDisplayed()) {
//                System.out.println(username + " " + password + "= " + "True");}
//            }catch(Exception e){
//            System.out.println(username + " " + password + "= " + "False");
//        }
//        SoftAssert soft = new SoftAssert();
//        soft.assertEquals(Driver.setDriver().getTitle().contains("Home"), success);
//        soft.assertAll();


try {
    Assert.assertEquals(Driver.setDriver().getTitle().contains("Home"), success);
}catch (Exception e){ }finally {
    Driver.quitDriver();
}

        Driver.quitDriver();




    }

    @Test
    void HeaderTest() {
        Driver.startUrl();
        BaseElements bs = new BaseElements();
        sendToElement(bs.getUsername(), "Admin");
        sendToElement(bs.getPassword(), "Admin123");
        clickElement(bs.getLocationList().get(new Random().nextInt(6)));
        clickElement(bs.getLoginButton());

        Actions action = new Actions(Driver.setDriver());
        action.moveToElement(bs.getAdmin()).build().perform();

        clickElement(bs.getMyAccount());
        Assert.assertTrue(bs.getMyAccountItem().isDisplayed());

        clickElement(bs.getLogOut());
        Assert.assertTrue(bs.getUsername().isDisplayed());

        Driver.quitDriver();
    }


    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "Admin123", true},
                {"admin", "Admin123", false},
                {"Admin", "admin123", false},
                {"Admin", "Admin 123", false},
                {"", "", false}
        };

    }
}
