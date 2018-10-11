package com.aws.framework.core.utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String PROPERTY_FILE = "input.properties";
    public static final String APP_PATH = "appPath";
    public static final String DRIVER_PATH = "driver";
    public static String DEVICE_NAME = "deviceName";
    public static final String PLATFORM_VERSION = "platformVersion";
    public static final String APPIUM_HUB = "appium";
    private static Properties config;

    private static Properties loadProperties(String fileName) throws Exception {
        Properties result = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream in = loader.getResourceAsStream(fileName);
        result.load(in);
        return result;
    }

    public static String getProperty(String key) {
        try {
            if (config == null) {
                String fileName = String.format(PROPERTY_FILE);
                config = loadProperties(fileName);
            }
            if (config.containsKey(key)) {
                return config.getProperty(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
