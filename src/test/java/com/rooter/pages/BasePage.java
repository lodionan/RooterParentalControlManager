package com.rooter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.rooter.utils.Browser;
import com.rooter.utils.Settings;
import com.rooter.utils.driver.DriverManager;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.webDriver(Browser.valueOf(Settings.getBrowser().toUpperCase()));
        PageFactory.initElements(driver, this);
    }

}
