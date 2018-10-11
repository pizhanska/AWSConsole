package com.aws.framework.core.pages;

import com.aws.framework.core.utils.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class BasePage {

    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected DriverFactory.DriverType type;


    public BasePage(DriverFactory.DriverType type){
        this.type = type;
        switch (type){
            case CHROME:
                PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
                break;
            case ANDROID:
                PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getInstance().getDriver()), this);
                break; }

    }

    public BasePage(){}


    //Waits
    public void waitElementToBeClicked(WebElement webElement, int sec) {
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), sec);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitElementToBeSelected(WebElement webElement, int sec) {
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), sec);
        wait.until(ExpectedConditions.elementToBeSelected(webElement));
    }

    public void waitElementToBeVisible(WebElement webElement, int sec) {
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), sec);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForAlert(int sec) {
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), sec);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForPageLoad(int sec) {
        new WebDriverWait(DriverFactory.getInstance().getDriver(), sec).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    //Swipe and scroll
    public void scrollPageUntilElementIsVisible(WebElement element) {
        if (type == DriverFactory.DriverType.CHROME) {
            js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
        } else {
            String elementID = ((RemoteWebElement)element).getId();
            HashMap<String, String> scrollObject = new HashMap<>();
            scrollObject.put("element", elementID);
            scrollObject.put("toVisible", "not an empty string");
            WebDriver driver = DriverFactory.getInstance().getDriver();
            AppiumDriver appiumDriver = (AppiumDriver) driver;
            appiumDriver.executeScript("mobile:scroll", scrollObject);
        }
    }

    public void scrollDownToThePageBottom(WebElement element) {
        if (type == DriverFactory.DriverType.CHROME) {
            js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } else {
            js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            HashMap scrollObjects = new HashMap();
            scrollObjects.put("direction", "down");
            scrollObjects.put("element", ((RemoteWebElement)element).getId());
            js.executeScript("mobile: scroll", scrollObjects);
        }
    }

    //Get title
    public String getPageTitle() {
        String title = DriverFactory.getInstance().getDriver().getTitle();
        return title;
    }
}
