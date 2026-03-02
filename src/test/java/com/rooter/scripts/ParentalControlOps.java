package com.rooter.scripts;

import com.rooter.Hook;
import com.rooter.model.Device;
import com.rooter.pages.OnHomePage;
import com.rooter.pages.OnLoginPage;
import com.rooter.pages.OnSecurityPage;
import com.rooter.utils.Settings;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ParentalControlOps extends Hook {

    @Test(testName = "Login to the rooter as Administrator")
    public void login() {
        OnLoginPage onLoginPage = new OnLoginPage();
        Assert.assertTrue(onLoginPage.isPageLoaded());

        onLoginPage.addUser(Settings.getUser());
        onLoginPage.addPassword(Settings.getPassword());
        onLoginPage.clickLoginButton();
    }

    @Test(testName = "As administrator I navigate to security tab", dependsOnMethods = "login")
    public void navigateToSecurity() {
        OnHomePage onHomePage = new OnHomePage();
        Assert.assertTrue(onHomePage.isPageLoaded());
        onHomePage.navigateToSecurityTab();
    }

    @Test(testName= "I navigate to Parental Control Option", dependsOnMethods = "navigateToSecurity")
    public void navigateToParentControl() {
        OnSecurityPage onSecurityPage = new OnSecurityPage();
        Assert.assertTrue(onSecurityPage.isPageLoaded());

        onSecurityPage.goToParentalControl();
        Assert.assertTrue(onSecurityPage.isFrameLoaded());
    }

    @Test(testName = "Execute parental control action",
            dependsOnMethods = "navigateToParentControl",
            dataProvider = "devices",
            dataProviderClass = Settings.class)
    public void executeAction(Device device) {
        String action = Settings.getAction();

        OnSecurityPage onSecurityPage = new OnSecurityPage();

        switch(action) {
            case "add":
                onSecurityPage.addDevices(device.getName(), device.getMacAddress());
                break;
            case "remove":
                onSecurityPage.removeDevices(device.getName(), device.getMacAddress());
                break;
            case "list":
            default:
                onSecurityPage.listDevices();
                break;
        }
    }

}
