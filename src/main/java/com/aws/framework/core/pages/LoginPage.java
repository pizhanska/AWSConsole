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

    @FindBy(id="resolving_input")
    private WebElement emailAddressField;

    @FindBy(id = "next_button")
    private WebElement nextBtn;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signin_button")
    private WebElement signInBtn;

    public void clickDropDownMenu() {
        waitElementToBeClicked(dropDownMenu, 5);
        dropDownMenu.click();
    }

    public void clickLogonWRootAccountBtn() {
        waitElementToBeClicked(loginWRootAccountBtn, 6);
        loginWRootAccountBtn.click();


    }

    public void fillEmailAddressField(String emailAddress) {
        waitElementToBeClicked(emailAddressField, 5);
        emailAddressField.sendKeys(emailAddress);
    }

    public void clickNextButton() {
        nextBtn.click();
    }

    public void fillPasswordField(String password) {
        waitElementToBeClicked(passwordField,5);
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }


}
