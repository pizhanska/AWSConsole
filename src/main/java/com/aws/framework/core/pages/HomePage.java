package com.aws.framework.core.pages;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='https://us-east-2.console.aws.amazon.com/ec2/v2/home?region=us-east-2']")
    private RemoteWebElement btnEC2Dashboard;

    @FindAll({@FindBy(id = "//android.widget.ListView/android.view.View[5]"),
              @FindBy(id = "gwt-debug-leftNav-Instances")})
    private RemoteWebElement btnEC2Instances;

    @FindBy(id = "gwt-debug-button-launch-instance")
    private RemoteWebElement btnCreateInstance;


    public void goToEC2Dashboard(){
        btnEC2Dashboard.click();
    }

    public void goToEC2Instances(){
        btnEC2Instances.click();
    }

    public void clickOnCreateInstance(){
        btnCreateInstance.click();
    }

}
