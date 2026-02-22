package com.rooter.scripts;

import com.rooter.Hook;
import com.rooter.pages.OnHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ParentalControl extends Hook {

    public static OnHomePage onHomePage;

    @Test(testName = "Login to the rooter as Administrator")
    public void login() {
        onLoginPage.clickLoginButton();
    }

    @Test(testName = "As administrator I navigate to security tab", dependsOnMethods = "login")
    public void navigateToSecurity() {

    }

}
