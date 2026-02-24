package com.rooter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.rooter.utils.Browser;
import com.rooter.utils.Settings;
import com.rooter.utils.driver.DriverManager;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        System.out.println("[DEBUG] BasePage inicializado con driver: " + driver.hashCode());
        PageFactory.initElements(driver, this);
    }
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        System.out.println("[DEBUG] BasePage recibe driver por inyección: " + driver.hashCode());
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }
}
