package com.globantu.automation.karen_vivas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BasePage {

protected WebDriver driver;

    /**
     * Constructor.
     */
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void doubleClickElement(WebElement element){
        Actions action = new Actions(driver);
        action.doubleClick().perform();
    }

}
