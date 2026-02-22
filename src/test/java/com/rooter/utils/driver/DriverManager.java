package com.rooter.utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.rooter.utils.Browser;
import com.rooter.utils.BrowserUtil;

public class DriverManager {

    static WebDriver driver;

    public static WebDriver webDriver(Browser type) {
        try {
            switch(type) {
                case CHROME:
                    driver = BrowserUtil.setUpChrome();
                    break;
                case EDGE:
                    driver = BrowserUtil.setUpEdge();
                    break;
                case FIREFOX:
                    driver = BrowserUtil.setUpFirefox();
                    break;
            }
        } catch(WebDriverException wde) {
            try {
                throw wde.getCause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
