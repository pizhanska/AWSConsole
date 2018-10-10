package com.aws.framework.core.pages;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class EC2InstancePage extends BasePage {

    @FindBy(id = "gwt-debug-searchTextBox")
    private RemoteWebElement searchAMI;

    @FindBy(xpath = "//button[@text='Select']")
    private RemoteWebElement btnSelectAMI;

    @FindBy(xpath = "//span[@text='Review and Launch']")
    private RemoteWebElement btnReviewAndLaunch;

    @FindBy(xpath = "//span[@text='Launch']")
    private RemoteWebElement btnLaunch;

    @FindBy(id = "gwt-debug-keypairAcknowledgeCheckbox-input")
    private RemoteWebElement chkKeyPairAccess;

    @FindBy(xpath = "//span[@text='Launch Instances']")
    private RemoteWebElement btnLaunchInstances;

    @FindBy(xpath = "//div[@class='awsui-alert-header awsui-text-big']")
    private RemoteWebElement alertLaunchedInstances;

    @FindBy(xpath = "//span[@text='The following instance launches have been initiated: ']/a")
    private RemoteWebElement getInstanceID;

    @FindBy(xpath = "//span[@text='View Instances']")
    private RemoteWebElement btnViewInstances;

    @FindBy(css = "#gwt-debug-gridTable > div:nth-child(3) > div > div:nth-child(2) > div > div > table > tbody > tr.GNAEPMSDIHB.GNAEPMSDMIB > td:nth-child(12) > div")
    private RemoteWebElement launchedInstance;

    @FindBy(id = "detailsInstanceState")
    private RemoteWebElement instanceState;

    public void typeSearchAMI(String AMIname){
        searchAMI.sendKeys(AMIname);
    }

    public void clickOnSelectAMI(){
        btnSelectAMI.click();
    }

    public void clickOnReviewAndLaunch(){
        btnReviewAndLaunch.click();
    }
    public void clickOnLaunch(){
        btnLaunch.click();
    }

    public void clickOnCHKKeyPairAccess(){
        chkKeyPairAccess.click();
    }

    public void clickOnLaunchInstances(){
        btnLaunchInstances.click();
    }

    public String getAlertMessage(){
        return alertLaunchedInstances.getText();
    }

    public void clickOnViewInstances(){
        btnViewInstances.click();
    }

    public void clickOnLaunchedInstance(){
        launchedInstance.click();
    }

    public String getInstanceState(){
        return instanceState.getText();
    }

    public String getInstanceId(){
        return getInstanceID.getText();
    }

}
