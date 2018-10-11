package com.aws.framework.core.pages;

import com.aws.framework.core.utils.DriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    public LoginPage(DriverFactory.DriverType type){
        switch (type){
            case CHROME:
                PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
                break;
            case ANDROID:
                PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getInstance().getDriver()), this);
                break;
        }
    }

    @FindBy(xpath = "(//*[@class='icon-caret-down lb-trigger-mount'])[2]")
    private WebElement dropDownMenu;

    @FindAll({@FindBy(xpath = "//android.view.View[@content-desc='ROOT Root Account']"), @FindBy(xpath = "//div[27]/ul/li[1]/a")})
    private WebElement loginWRootAccountBtn;

    @FindAll({@FindBy(id="resolving_input"), @FindBy(xpath = "//android.webkit.WebView[@content-desc=\"Amazon Web Services Sign-In\"]/android.view.View[9]/android.widget.EditText")})
    private WebElement emailAddressField;

    @FindAll({@FindBy(id = "next_button"), @FindBy(xpath = "//android.widget.Button[@content-desc='Next']")})
    private WebElement nextBtn;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signin_button")
    private WebElement signInBtn;

    public void clickDropDownMenu() {
        waitElementToBeClickable(dropDownMenu, 5);
        dropDownMenu.click();
    }

    public void clickLogonWRootAccountBtn() {
        waitElementToBeClickable(loginWRootAccountBtn, 6);
        loginWRootAccountBtn.click();
    }

    public void fillEmailAddressField(String emailAddress) {
        waitElementToBeClickable(emailAddressField, 5);
        emailAddressField.sendKeys(emailAddress);
    }

    public void clickNextButton() {
        nextBtn.click();
    }

    public void fillPasswordField(String password) {
        waitElementToBeClickable(passwordField,5);
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }


}
