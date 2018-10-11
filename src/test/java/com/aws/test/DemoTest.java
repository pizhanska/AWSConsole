package com.aws.test;

import com.aws.framework.businessflow.EC2InstanceOperationsWorkflow;
import com.aws.framework.core.utils.DriverFactory;
import com.aws.utils.DataProv;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DemoTest extends BaseTest{

    public EC2InstanceOperationsWorkflow ec2InstanceOperationsWorkflowWeb;
    public EC2InstanceOperationsWorkflow ec2InstanceOperationsWorkflowMobile;
    public WebDriver androidDriver;
    public WebDriver chromeDriver;
    public String instanceId;

    @Test(groups = {"initForWeb"})
    public void initForWeb(){
        chromeDriver = DriverFactory.getInstance().getDriver();
        chromeDriver.get("https://aws.amazon.com/");
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        ec2InstanceOperationsWorkflowWeb = new EC2InstanceOperationsWorkflow(DriverFactory.DriverType.CHROME);
    }

    @Test(dependsOnMethods = {"initForWeb"},
            dataProviderClass = DataProv.class, dataProvider = "createInstance")
    public void createInstanceThroughWebView(String email, String password, String machine, String state){
        ec2InstanceOperationsWorkflowWeb.loginAsRoot(l ->{
            l.clickDropDownMenu();
            l.clickLogonWRootAccountBtn();
            l.fillEmailAddressField(email);
            l.clickNextButton();
            l.fillPasswordField(password);
            l.clickSignInBtn();
        });

        ec2InstanceOperationsWorkflowWeb.chooseInstance(c ->{
           c.goToEC2Dashboard();
           c.goToEC2Instances();
           c.clickOnCreateInstance();
        });

        ec2InstanceOperationsWorkflowWeb.createInstance(c ->{
           c.typeSearchAMI(machine);
           c.clickOnSelectAMI();
           c.clickOnReviewAndLaunch();
           c.clickOnLaunch();
           c.clickOnCHKKeyPairAccess();
           c.clickOnLaunchInstances();
        });

        ec2InstanceOperationsWorkflowWeb.checkInstance(c ->{
           instanceId = c.getInstanceId();
           c.clickOnLaunchedInstance();
           Assert.assertEquals(c.getInstanceState(), state);
        });
    }


    @AfterTest
    public void close(){
        DriverFactory.getInstance().getDriver().quit();
    }
}
