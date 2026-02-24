package com.rooter.pages;

import com.rooter.utils.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnSecurityPage extends BasePage {

    @FindBy(id = "firewallleveltitle_content")
    WebElement title;

    @FindBy(id= "parental_content")
    WebElement parentalControlTitle;

    @FindBy(id = "subdiv_parentalctrlstatus")
    WebElement parentalControlButton;

    public OnSecurityPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        PageUtil.waitForElementBeDisplayed(driver, By.id("firewallleveltitle_content"), 10);
        return title.isDisplayed();
    }

    public void goToParentalControl() {
        parentalControlButton.click();
    }

    public boolean isModalLoaded() {
        return parentalControlTitle.isDisplayed();
    }
}
