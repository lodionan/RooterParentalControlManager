package com.rooter.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageUtil {

    public static void waitForElementBeDisplayed(WebDriver driver, By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementBeDisplayed(WebDriver driver, WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementExistAndIsDisplayed(WebDriver driver, By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clearAndSendKeys(WebDriver driver, By locator, String keys) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(keys);
    }

    public static void selectByVisibleText(WebElement deviceList, String value) {
        deviceList.click();
        Select select = new Select(deviceList);
        select.selectByVisibleText(value);
    }
}
