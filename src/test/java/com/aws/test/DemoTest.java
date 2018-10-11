package com.aws.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DemoTest {

    private static Logger logger = LogManager.getLogger(DemoTest.class);
    @Test
    public void test() {
        Assert.assertTrue(true);
        String message = "The message to check if logger works";
        logger.info(message);
    }
}
