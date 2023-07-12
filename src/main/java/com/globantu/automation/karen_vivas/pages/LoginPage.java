package com.globantu.automation.karen_vivas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "#loginFormEmailInput")
    private WebElement emailField;

    @FindBy(css = "#loginFormPasswordInput")
    private WebElement passwordField;

    @FindBy(css = "#loginFormSubmitButton")
    private WebElement loginButton;

    /**
     * Constructor.
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
