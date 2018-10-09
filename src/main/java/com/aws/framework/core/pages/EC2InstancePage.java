package com.aws.framework.core.pages;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class EC2InstancePage extends BasePage {

    @FindBy(id = "gwt-debug-searchTextBox")
    private RemoteWebElement searchAMI;

    public void typeSearchAMI(String AMIname){
        searchAMI.sendKeys(AMIname);
    }

}
