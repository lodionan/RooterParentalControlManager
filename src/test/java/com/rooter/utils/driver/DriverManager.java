package com.rooter.utils.driver;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.rooter.utils.Browser;
import com.rooter.utils.BrowserUtil;

import static org.testng.Reporter.log;

@Slf4j
public class DriverManager {

    @Setter
    static Browser browserType;
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            log("DriverManager: driver already exist, hashCode=" + driver.hashCode());
            return driver;
        }
        
        log("DriverManager: Creating new driver for " + browserType);
        try {
            switch(browserType) {
                case CHROME:
                    driver = BrowserUtil.setUpChrome();
                    break;
                case EDGE:
                    driver = BrowserUtil.setUpEdge();
                    break;
                case FIREFOX:
                    driver = BrowserUtil.setUpFirefox();
                    break;
                default:
                    System.out.println("[WARN] DriverManager: browserType no configurado, usando CHROME por defecto");
                    driver = BrowserUtil.setUpChrome();
                    break;
            }
        } catch(WebDriverException wde) {
            try {
                throw wde.getCause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("[DEBUG] DriverManager: driver creado con hashCode=" + driver.hashCode());
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
