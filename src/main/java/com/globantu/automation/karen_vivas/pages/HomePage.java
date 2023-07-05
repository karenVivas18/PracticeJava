package com.globantu.automation.karen_vivas.pages;

import org.openqa.selenium.Keys;
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
    @FindBy(css = "[data-stid='origin_select-menu-trigger']")
    private WebElement originField;
    @FindBy(css = "[data-stid='origin_select-menu-input']")
    private WebElement originBox;
    @FindBy(css = "[data-stid='destination_select-menu-trigger']")
    private WebElement destinationField;
    @FindBy(css = "[data-stid='destination_select-menu-input']")
    private WebElement destinationBox;
    @FindBy(css = "#date_form_field-btn")
    private WebElement dateField;
    @FindBy(css = ".uitk-date-picker-weeks .uitk-date-picker-day-number.uitk-date-picker-first-of-month")
    private WebElement firstDate;
    @FindBy(css = "#FlightSearchForm_ROUND_TRIP .uitk-calendar button:nth-child(2)")
    private WebElement nextMonthBtn;
    @FindBy(css = "[data-stid='open-room-picker']")
    private WebElement travelersBtn;
    @FindBy(css = "[data-stid='travelers_selector_done_button']")
    private WebElement doneTravelersBtn;
    @FindBy(css = "[data-stid='apply-date-picker']")
    private WebElement doneDateBtn;
    @FindBy(css = "#search_button")
    private WebElement searchBtn;

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
    public void goFlightsSearch(){
        flights.click();
    }
    public void selectOrigin(String origin){
        originField.click();
        originBox.sendKeys(origin);
        originBox.sendKeys(Keys.ENTER);
    }
    public void selectDest(String destination){
        destinationField.click();
        destinationBox.sendKeys(destination);
        destinationBox.sendKeys(Keys.ENTER);
    }
    public void selectDate(){
        dateField.click();
        firstDate.click();
        doubleClickElement(nextMonthBtn);
        firstDate.click();
    }
    public void clickDoneDate(){
        doneDateBtn.click();
    }
}
