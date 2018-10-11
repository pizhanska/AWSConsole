package com.aws.framework.core.pages;

import com.aws.framework.core.utils.DriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EC2InstancePage extends BasePage {

    public EC2InstancePage(DriverFactory.DriverType type){
        switch (type){
            case CHROME:
                PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
                break;
            case ANDROID:
                PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getInstance().getDriver()), this);
                break;
        }
    }

    @FindBy(id = "gwt-debug-searchTextBox")
    private WebElement searchAMI;

    @FindBy(xpath = "//*[@id='gwt-debug-myAMIList']/div[2]/div[1]/div[2]//div/div[2]/div/button")
    private WebElement btnSelectAMI;

    @FindBy(xpath = "//*[@id='gwt-debug-finishWizard-button']/span[3]")
    private WebElement btnReviewAndLaunch;

    @FindBy(xpath = "//*[@id='gwt-debug-liwLaunchInstance-button']/span[3]")
    private WebElement btnLaunch;

    @FindBy(xpath = "//*[@id='gwt-debug-keypairAcknowledgeCheckbox-input']")
    private WebElement chkKeyPairAccess;

    @FindBy(xpath = "//*[@id='gwt-debug-keyPairWarningButton-button']")
    private WebElement btnLaunchInstances;

    @FindBy(xpath = "//*[@id='gwt-debug-keyPairWarningButton-button']")
    private WebElement alertLaunchedInstances;

    @FindBy(xpath = "//*[@id='gwt-debug-instanceIDWrapper']/span/a")
    private WebElement getInstanceID;

    @FindBy(xpath = "//*[@id='ec2base']/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/div[6]/div[2]/button/span[3]")
    private WebElement btnViewInstances;


    @FindBy(xpath = "//*[@id='gwt-debug-gridTable']/div[3]/div/div[2]/div/div/table/tbody/tr/td[6]/div/span")
    private WebElement instanceState;

    @FindBy(xpath = " //*[@id='gwt-debug-gridTable']/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[1]/div/img")
    private WebElement spinner;




    public void typeSearchAMI(String AMIname){
        waitElementToBeClickable(searchAMI, 5);
        searchAMI.sendKeys(AMIname);
        searchAMI.sendKeys(Keys.ENTER);
    }

    public void clickOnSelectAMI(){
        waitElementToBeClickable(btnSelectAMI, 5);
        btnSelectAMI.click();
    }

    public void clickOnReviewAndLaunch(){
        waitElementToBeClickable(btnReviewAndLaunch, 5);
        btnReviewAndLaunch.click();
    }
    public void clickOnLaunch(){
        waitElementToBeClickable(btnLaunch, 5);
        btnLaunch.click();
    }

    public void clickOnCHKKeyPairAccess(){
        waitElementToBeClickable(chkKeyPairAccess, 5);
        chkKeyPairAccess.click();
    }

    public void clickOnLaunchInstances(){
        waitElementToBeClickable(btnLaunchInstances, 10);
        btnLaunchInstances.click();
    }

    public String getAlertMessage(){
        return alertLaunchedInstances.getText();
    }

    public void clickOnViewInstances(){
        waitElementToBeClickable(btnViewInstances,5);
        btnViewInstances.click();
    }

    public void clickOnLaunchedInstance(){
        waitElementToBeClickable(getInstanceID, 5);
        getInstanceID.click();
    }

    public String getInstanceState(){
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.textToBePresentInElement(instanceState, "running"));
        return instanceState.getText();
    }

    public String getInstanceId(){
        waitElementToBeClickable(getInstanceID, 5);
        return getInstanceID.getText();
    }

}
