package com.globantu.automation.karen_vivas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void doubleClickElement(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick().perform();
    }

    public void waitElementVisible(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

}
