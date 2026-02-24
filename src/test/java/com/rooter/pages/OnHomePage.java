package com.rooter.pages;

import com.rooter.utils.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OnHomePage extends BasePage {

    @FindBy(id = "ImageTelmexText")
    WebElement ispLogo;

    @FindBy(xpath = "//div[text()='Seguridad']")
    WebElement securityTab;

    public OnHomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        PageUtil.waitForElementBeDisplayed(driver, By.id("ImageTelmexText"), 10);
        return ispLogo.isDisplayed();
    }

    public void navigateToSecurityTab() {
        securityTab.click();
    }
}
