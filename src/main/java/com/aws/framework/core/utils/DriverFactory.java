package com.aws.framework.core.utils;


import com.aws.framework.core.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();
    private static DesiredCapabilities caps;
    private static WebDriver driver;

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        return new ChromeDriver(DesiredCapabilities.chrome());
    };

    //android driver supplier
    private static final Supplier<WebDriver> androidDriverSupplier = () -> {
        File app = new File( "src/test/resources/LivingTree.apk");
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 27");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,  "8.1");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability("newCommandTimeout", 10);
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("autoGrantPermissions", "true");
        try {
            driver = new AppiumDriver(new URL("http://0.0.0.0:4724/wd/hub"), caps);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    };


    static{
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.ANDROID,androidDriverSupplier);
    }

    //return a new driver from the map
    public static WebDriver getDriver(DriverType type){
        return driverMap.get(type).get();
    }


    public enum DriverType{
        CHROME,
        ANDROID
    }
}
