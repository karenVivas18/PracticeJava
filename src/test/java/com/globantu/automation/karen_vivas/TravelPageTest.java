package com.globantu.automation.karen_vivas;

import com.globantu.automation.karen_vivas.commun.DriverManager;
import com.globantu.automation.karen_vivas.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class TravelPageTest {
    private DriverManager driver;
    private HomePage home;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new DriverManager(browser);
        home = new HomePage(driver.getDriver(), url);
    }

    @Test()
    public void booking() {
        if (home.isUserLogged()) {
            home.logOut();
        }
        //Search for a flight from LAS to LAX, 1 adult (clicking on Flight/Roundtrip). Dates should be at least two month in the future and MUST be selected using the datepicker calendar.
        home.goFlightsSearch();
        home.selectOrigin("LAS");
        home.selectDest("LAX");
        home.selectDate();
        home.clickDoneDate();
        home.selectTravelers1();
        home.clickSearch();
        Assert.assertTrue("contain Las Vegas", home.flyingFromResult().contains("Las Vegas"));
        Assert.assertTrue("contain Los Angeles", home.flyingToResult().contains("Los Angeles"));
        home.clickOptionSort("DURATION_INCREASING");

    }
}
