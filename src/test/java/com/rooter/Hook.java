package com.rooter;

import com.rooter.pages.OnLoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.rooter.utils.Settings;
import com.rooter.utils.driver.DriverManager;

public class Hook {

    public OnLoginPage onLoginPage = new OnLoginPage();

    @BeforeTest
    public void setUp() {

        Assert.assertTrue(onLoginPage.isPageLoaded());

        onLoginPage.addUser(Settings.getUser());
        onLoginPage.addPassword(Settings.getPassword());
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
