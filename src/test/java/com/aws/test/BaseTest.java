package com.aws.test;

import com.aws.framework.businessflow.EC2InstanceOperationsWorkflow;
import com.aws.framework.core.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    @BeforeClass
    public void setUp(){
        Assert.assertTrue(true);

        //androidDriver =  new DriverFactory(DriverFactory.DriverType.ANDROID).getDriver();
       // ec2InstanceOperationsWorkflowWeb = new EC2InstanceOperationsWorkflow(DriverFactory.DriverType.CHROME);
        //ec2InstanceOperationsWorkflowMobile = new EC2InstanceOperationsWorkflow(DriverFactory.DriverType.ANDROID);
    }
}
