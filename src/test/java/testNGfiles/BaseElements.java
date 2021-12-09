package testNGfiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class BaseElements {


    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//*[@id='sessionLocation']//li")
    private List<WebElement> locationList;
    @FindBy(id = "loginButton")
    private WebElement loginButton;
    @FindBy(css = "[id='navbarSupportedContent'] >ul >li")
    private WebElement admin;
    @FindBy(id = "error-message")
    private WebElement errorMessage;
    @FindBy(xpath = "//a[contains(.,'My Account')]")
    private WebElement myAccount;
    @FindBy(xpath = "//a[contains(.,'Logout')]")
    private WebElement logOut;

    public WebElement getLogOut() {
        return logOut;
    }

    public WebElement getMyAccountItem() {
        return myAccountItem;
    }

    @FindBy(css = "div[class='task'] >i")
    private WebElement myAccountItem;

    public BaseElements() {

        PageFactory.initElements(Driver.setDriver(), this);
    }

    public WebElement getMyAccount() {
        return myAccount;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getAdmin() {
        return admin;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public List<WebElement> getLocationList() {
        return locationList;
    }


}
