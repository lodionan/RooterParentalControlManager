package com.rooter.scripts;

import com.rooter.Hook;
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
        //onHomePage = new OnHomePage();
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
        Assert.assertTrue(onSecurityPage.isPageLoaded());
    }


}
