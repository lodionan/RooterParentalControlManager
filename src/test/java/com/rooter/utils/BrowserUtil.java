package com.rooter.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserUtil {

    public static WebDriver setUpChrome() {

        return new ChromeDriver((ChromeOptions) browserOptions("chrome"));
    }

    public static WebDriver setUpEdge() {

        return new EdgeDriver((EdgeOptions) browserOptions("edge"));
    }

    public static WebDriver setUpFirefox() {
        FirefoxOptions options = new FirefoxOptions();

        options.setAcceptInsecureCerts(true);

        return new FirefoxDriver(options);
    }

    private static ChromiumOptions<?> browserOptions(String browserType) {

        ChromiumOptions<?> options = null;

        switch(browserType) {
            case "chrome":
                options = new ChromeOptions();
                break;
            case "edge":
                options = new EdgeOptions();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserType);
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");

        return options;
    }
}
