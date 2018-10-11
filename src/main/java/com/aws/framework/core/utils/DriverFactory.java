package com.aws.framework.core.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.function.Supplier;

public class DriverFactory {
    private DriverType type ;


    private DesiredCapabilities caps;
    private WebDriver driver;

    private static DriverFactory driverFactory =  new DriverFactory();

    private DriverFactory(){}

    //chrome driver supplier
    private final Supplier<WebDriver> driverSupplier = () -> {
                                                                                                                                                                                type = DriverType.CHROME;
        if(driver == null ) {
            switch (type){
                case CHROME:
                    System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
                    driver = new ChromeDriver(new ChromeOptions());
                break;
                case ANDROID:
                    File app = new File(Config.getProperty(Config.APP_PATH));
                    caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, Config.getProperty(Config.DEVICE_NAME));
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, Config.getProperty(Config.PLATFORM_VERSION));
                    caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                    caps.setCapability("newCommandTimeout", 10);
                    caps.setCapability("skipUnlock", "true");
                    caps.setCapability("autoGrantPermissions", "true");
                    try {
                        driver = new AppiumDriver(new URL(Config.getProperty(Config.APPIUM_HUB)), caps);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }
        }
        return driver;
    };


    public static DriverFactory getInstance(){
        return driverFactory;
    }

    public WebDriver getDriver(){
        return driverSupplier.get();
    }


    public enum DriverType{
        CHROME,
        ANDROID
    }
}
