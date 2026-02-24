package com.rooter;

import com.rooter.pages.OnLoginPage;

import com.rooter.utils.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.rooter.utils.Settings;
import com.rooter.utils.driver.DriverManager;

public class Hook {

    @BeforeTest
    public void setUp() {
        DriverManager.setBrowserType(
                Browser.valueOf(Settings.getBrowser().toUpperCase()));
        DriverManager.getDriver().navigate().to(Settings.getRooterURL());
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
