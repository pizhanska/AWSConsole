package com.aws.framework.core.pages;

import com.aws.framework.core.utils.DriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//*[@id='all-services-itemec2']/a/span")
    private WebElement btnEC2Dashboard;

    @FindAll({@FindBy(id = "//android.widget.ListView/android.view.View[5]"),
              @FindBy(id = "gwt-debug-leftNav-Instances")})
    private WebElement btnEC2Instances;

    @FindBy(id = "gwt-debug-button-launch-instance")
    private WebElement btnCreateInstance;


    public void goToEC2Dashboard(){
        waitElementToBeClickable(btnEC2Dashboard, 5);
        btnEC2Dashboard.click();
    }

    public void goToEC2Instances(){
        waitElementToBeClickable(btnEC2Instances, 7);
        btnEC2Instances.click();
    }

    public void clickOnCreateInstance(){
        waitElementToBeClickable(btnCreateInstance, 5);
        btnCreateInstance.click();
    }

}
