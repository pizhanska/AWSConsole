package com.aws.framework.core.pages;

import com.aws.framework.core.utils.DriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(DriverFactory.DriverType type){
        switch (type){
            case CHROME:
                PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
                break;
            case ANDROID:
                PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getInstance().getDriver()), this);
                break;
        }
    }

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
