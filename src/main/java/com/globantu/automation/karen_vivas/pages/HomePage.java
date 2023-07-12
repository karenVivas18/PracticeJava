package com.globantu.automation.karen_vivas.pages;

import com.globantu.automation.karen_vivas.commun.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;


public class HomePage extends BasePage {
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

    @FindBy(css = "#gc-custom-header-nav-bar-acct-menu")
    private WebElement signBtn1;
    @FindBy(css = "[data-stid='link-header-account-signin']")
    private WebElement signInOption;
    //@FindBy(xpath="//*[@id='multi-product-search-form-1']/div/div/div[1]/ul/li[2]")
    @FindBy(css = "a.uitk-tab-anchor[href='Flights']")
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
    @FindBy(css = "#traveler_selector_adult_step_input-0")
    private WebElement adultTravelers;
    @FindBy(css = "[data-stid='travelers_selector_done_button']")
    private WebElement doneTravelersBtn;
    @FindBy(css = "[data-stid='apply-date-picker']")
    private WebElement doneDateBtn;
    @FindBy(css = "#search_button")
    private WebElement searchBtn;
    @FindBy(css = "button [aria-label='Decrease the number of adults in room 1']")
    private WebElement decreaseAdultBtn;
    @FindBy(css = "button [aria-label='Increase the number of adults in room 1']")
    private WebElement increaseAdultBtn;
    @FindBy(css = "[data-stid='typeahead-originInput-0-menu-trigger']")
    private WebElement flyingFromResult;
    @FindBy(css = "[data-stid='typeahead-destinationInput-0-menu-trigger']")
    private WebElement flyingToResult;
    @FindBy(css = "#sort-filter-dropdown-SORT")
    private WebElement sortDropDown;
    @FindBy(css = "[data-test-id='price-column']")
    private WebElement priceColumn;

    private Actions actions;

    public void goToHomePage() {
        driver.get(url);
    }

    public boolean isUserLogged() {

        waitElementVisible(signBtn1);
        signBtn1.click();
        try {
            return signInOption.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public HomePage logOut() {
        signBtn1.click();
        signOutBtn.click();
        return this;
    }

    public LoginPage clickSingIn() {
        signBtn1.click();
        signInOption.click();
        return new LoginPage(driver);
    }

    public void goFlightsSearch() {
        new WebDriverWait(driver, 20);
        flights.click();
    }

    public void selectOrigin(String origin) {
        originField.click();
        originBox.sendKeys(origin);
        originBox.sendKeys(Keys.ENTER);
    }

    public void selectDest(String destination) {
        destinationField.click();
        destinationBox.sendKeys(destination);
        destinationBox.sendKeys(Keys.ENTER);
    }

    public void selectDate() {
        dateField.click();
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(13);
        String todayFormatted = Actions.formatLocalDate(today);
        String endDateFormatted = Actions.formatLocalDate(endDate);

        WebElement todayElement = driver.findElement(By.xpath("//td[@aria-label='" + todayFormatted + "']"));
        WebElement endDateElement = driver.findElement(By.xpath("//td[@aria-label='" + endDateFormatted + "']"));

        todayElement.click();
        endDateElement.click();
    }

    public void clickDoneDate() {
        doneDateBtn.click();
    }

    public void selectTravelers1() {
        travelersBtn.click();
        int selectedTraveler = Integer.parseInt(adultTravelers.getAttribute("value"));
        if (selectedTraveler == 1) {
            doneTravelersBtn.click();
            return;
        }
        if (selectedTraveler == 0) {
            increaseAdultBtn.click();
        }
        IntStream.rangeClosed(2, selectedTraveler)
                .forEach(i -> decreaseAdultBtn.click());
        doneTravelersBtn.click();
    }

    public void clickSearch() {
        searchBtn.click();
    }

    public String flyingFromResult() {
        return flyingFromResult.getText();
    }

    public String flyingToResult() {
        return flyingToResult.getText();
    }

    public void clickSortBy() {
        sortDropDown.click();
    }

    public void clickOptionSort(String value) {
        WebElement optionSort = actions.findOptionsByValue(value);
        optionSort.click();
    }
}
