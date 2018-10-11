package com.aws.framework.businessflow;

import com.aws.framework.core.pages.BasePage;
import com.aws.framework.core.pages.EC2InstancePage;
import com.aws.framework.core.pages.HomePage;
import com.aws.framework.core.pages.LoginPage;
import com.aws.framework.core.utils.DriverFactory;

import java.util.function.Consumer;


public class EC2InstanceOperationsWorkflow {

    private LoginPage loginPage;
    private BasePage basePage;
    private HomePage homePage;
    private EC2InstancePage ec2InstancePage;

    public EC2InstanceOperationsWorkflow(DriverFactory.DriverType driverType) {
        switch (driverType) {
            case ANDROID:
                loginPage = new LoginPage(DriverFactory.DriverType.ANDROID);
                basePage = new BasePage(DriverFactory.DriverType.ANDROID);
                homePage = new HomePage(DriverFactory.DriverType.ANDROID);
                ec2InstancePage = new EC2InstancePage(DriverFactory.DriverType.ANDROID);
                break;
            case CHROME:
                loginPage = new LoginPage(DriverFactory.DriverType.CHROME);
                basePage = new BasePage(DriverFactory.DriverType.CHROME);
                homePage = new HomePage(DriverFactory.DriverType.CHROME);
                ec2InstancePage = new EC2InstancePage(DriverFactory.DriverType.CHROME);
        }
    }

    public EC2InstanceOperationsWorkflow(){}

    public EC2InstanceOperationsWorkflow loginAsRoot(Consumer<LoginPage> c) {
        c.accept(loginPage);
        return new EC2InstanceOperationsWorkflow();
    }


    public EC2InstanceOperationsWorkflow chooseInstance(Consumer<HomePage> c) {
        c.accept(homePage);
        return new EC2InstanceOperationsWorkflow();
    }

    public EC2InstanceOperationsWorkflow createInstance(Consumer<EC2InstancePage> c) {
        c.accept(ec2InstancePage);
        return new EC2InstanceOperationsWorkflow();
    }

    public EC2InstanceOperationsWorkflow checkInstance(Consumer<EC2InstancePage> c) {
        c.accept(ec2InstancePage);
        return new EC2InstanceOperationsWorkflow();
    }
}
