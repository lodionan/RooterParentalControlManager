package com.rooter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OnSecurityPage extends BasePage {

    public OnSecurityPage() {
        super();
        PageFactory.initElements(driver, this);
    }
}
