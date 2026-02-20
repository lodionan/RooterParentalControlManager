package com.rooter.steps;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.BrowserUtil;
import utils.Settings;

public class Hook {

    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        String browserType = Settings.getBrowser();

        switch (browserType.toLowerCase()) {
            case "edge":
                driver = BrowserUtil.setUpEdge();
                break;
            case "firefox":
                driver = BrowserUtil.setUpFirefox();
                break;
            default:
                driver = BrowserUtil.setUpChrome();
        }

    }

    @BeforeTest(dependsOnMethods = {"setUp"})
    public void navigateToURL() {
        driver.navigate().to(Settings.getRooterURL());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
