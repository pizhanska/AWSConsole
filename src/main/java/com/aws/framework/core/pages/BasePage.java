package com.aws.framework.core.pages;

import com.aws.framework.core.utils.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class BasePage {

    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    //Waits
    public void waitElementToBeClicked(DriverFactory.DriverType type, RemoteWebElement webElement, int sec) {
        wait = new WebDriverWait(DriverFactory.getDriver(type), sec);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitElementToBeSelected(DriverFactory.DriverType type,RemoteWebElement webElement, int sec) {
        wait = new WebDriverWait(DriverFactory.getDriver(type), sec);
        wait.until(ExpectedConditions.elementToBeSelected(webElement));
    }

    public void waitElementToBeVisible(DriverFactory.DriverType type,RemoteWebElement webElement, int sec) {
        wait = new WebDriverWait(DriverFactory.getDriver(type), sec);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForAlert(DriverFactory.DriverType type, int sec) {
        wait = new WebDriverWait(DriverFactory.getDriver(type), sec);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForPageLoad(DriverFactory.DriverType type, int sec) {
        new WebDriverWait(DriverFactory.getDriver(type), sec).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    //Swipe and scroll
    public void scrollPageUntilElementIsVisible(DriverFactory.DriverType type, RemoteWebElement element) {
        if (type == DriverFactory.DriverType.CHROME) {
            js = (JavascriptExecutor) DriverFactory.getDriver(type);
            js.executeScript("arguments[0].scrollIntoView();", element);
        } else {
            String elementID = element.getId();
            HashMap<String, String> scrollObject = new HashMap<>();
            scrollObject.put("element", elementID);
            scrollObject.put("toVisible", "not an empty string");
            WebDriver driver = DriverFactory.getDriver(type);
            AppiumDriver appiumDriver = (AppiumDriver) driver;
            appiumDriver.executeScript("mobile:scroll", scrollObject);
        }
    }

    public void scrollDownToThePageBottom(DriverFactory.DriverType type, RemoteWebElement element) {
        if (type == DriverFactory.DriverType.CHROME) {
            js = (JavascriptExecutor) DriverFactory.getDriver(type);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } else {
            js = (JavascriptExecutor) DriverFactory.getDriver(type);
            HashMap scrollObjects = new HashMap();
            scrollObjects.put("direction", "down");
            scrollObjects.put("element", element.getId());
            js.executeScript("mobile: scroll", scrollObjects);
        }
    }

    //Get title
    public String getPageTitle(DriverFactory.DriverType type) {
        String title = DriverFactory.getDriver(type).getTitle();
        return title;
    }
}
