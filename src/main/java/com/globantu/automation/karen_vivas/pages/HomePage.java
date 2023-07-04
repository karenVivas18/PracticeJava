package com.globantu.automation.karen_vivas.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    protected static String url = "https://www.travelocity.com/";
    /**
     * Constructor.
     *
     * @param driver
     * @param url
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    @FindBy(css="#gc-custom-header-nav-bar-acct-menu > button")
    private WebElement signBtn1 ;
    @FindBy(css="[data-stid='link-header-account-signin']")
    private WebElement signInOption;
    @FindBy(xpath="//*[@id='multi-product-search-form-1']/div/div/div[1]/ul/li[2]")
    private WebElement flights;
    @FindBy(css = "a[href*='/user/logout']")
    private WebElement signOutBtn;

    public void goToHomePage(){
        driver.get(url);
    }
    public boolean isUserLogged(){
        try {
            return signInOption.isDisplayed();
        }catch (NoSuchElementException e) {
            return true;
        }
    }

    public HomePage logOut(){
        signBtn1.click();
        signOutBtn.click();
        return this;
    }
    public LoginPage clickSingIn(){
        signBtn1.click();
        signInOption.click();
    return new LoginPage(driver);
    }

}
