package com.rooter.pages;

import com.rooter.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class OnSecurityPage extends BasePage {

    @FindBy(id = "frameContent")
    WebElement frame;

    @FindBy(name = "subdiv_parentalctrlstatus")
    WebElement parentalControlButton;

    @FindBy(id = "pccframeContent")
    WebElement deviceFilterFrame;

    public OnSecurityPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        driver.switchTo().frame(frame);
        WebElement title = driver.findElement(By.id("firewallleveltitle_content"));

        PageUtil.waitForElementBeDisplayed(driver, title, 10);
        boolean isElementDisplayed = title.isDisplayed();
        driver.switchTo().defaultContent();
        return isElementDisplayed;
    }

    public void goToParentalControl() {
        parentalControlButton.click();
    }

    public boolean isFrameLoaded() {
        driver.switchTo().frame(frame);
        WebElement title = driver.findElement(By.id("parental_content"));

        PageUtil.waitForElementBeDisplayed(driver, title, 10);
        return title.isDisplayed();
    }

    public void addDevices(String deviceName, String macValue) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame);
        driver.switchTo().frame(deviceFilterFrame);

        PageUtil.waitForElementBeDisplayed(driver, By.id("Newbutton"), 10);

        driver.findElement(By.id("Newbutton")).click();

        PageUtil.waitForElementExistAndIsDisplayed(driver, By.id("Newbutton"), 10);

        WebElement deviceList = driver.findElement(By.id("ChildrenList"));
        PageUtil.selectByVisibleText(deviceList, "Introducir la dirección MAC manualmente");

        PageUtil.waitForElementExistAndIsDisplayed(driver, By.id("macAddr"), 10);
        PageUtil.clearAndSendKeys(driver, By.id("macAddr"), macValue);
        PageUtil.clearAndSendKeys(driver, By.id("ChildrenInfo"), deviceName);

        WebElement template = driver.findElement(By.id("TemplateList"));
        template.click();
        PageUtil.selectByVisibleText(template, "Schedule");

        driver.findElement(By.id("ButtonApply")).click();

        try {
            Thread.sleep(5000);
        } catch(Exception e) {
            log.info(e.getMessage());
        }
    }

    public void removeDevices(String deviceName, String macValue) {
        //todo: semantic step by now, implementation will be out soon
    }

    public void listDevices() {
        //todo: semantic step by now, implementation will be out soon
    }

}
