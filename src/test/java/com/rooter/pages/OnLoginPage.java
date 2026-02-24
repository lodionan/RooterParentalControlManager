package com.rooter.pages;

import com.rooter.utils.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rooter.utils.PageUtil;
import org.openqa.selenium.support.PageFactory;

public class OnLoginPage extends BasePage {

    @FindBy(xpath = "//img")
    WebElement ispLogo;

    @FindBy(id = "txt_Username")
    WebElement userField;

    @FindBy(id = "txt_Password")
    WebElement passwordField;

    @FindBy(id = "button")
    WebElement loginButton;

    public OnLoginPage() {
        super();
    }

    public boolean isPageLoaded() {
        PageUtil.waitForElementBeDisplayed(driver,
                By.xpath("//img"), 10);

        return ispLogo.isDisplayed();
    }

    public void addUser(String user) {
        userField.clear();
        userField.sendKeys(user);
    }

    public void addPassword(String pass) {
        passwordField.clear();
        passwordField.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
