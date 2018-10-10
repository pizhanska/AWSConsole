package com.aws.framework.core.pages;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "(//*[@class='icon-caret-down lb-trigger-mount'])[2]")
    private RemoteWebElement dropDownMenu;

    @FindAll({@FindBy(id = "ROOT Root Account"), @FindBy(xpath = "//div[27]/ul/li[1]/a")})
    private RemoteWebElement loginWRootAccountBtn;

    @FindBy(id="resolving_input")
    private RemoteWebElement emailAddressField;

    @FindBy(id = "next_button")
    private RemoteWebElement nextBtn;

    @FindBy(id = "password")
    private RemoteWebElement passwordField;

    @FindBy(id = "signin_button")
    private RemoteWebElement signInBtn;

    public void clickDropDownMenu() {
        dropDownMenu.click();
    }

    public void clickLogonWRootAccountBtn() {
        loginWRootAccountBtn.click();
    }

    public void fillEmailAddressField(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
    }

    public void clickNextButton() {
        nextBtn.click();
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }


}
