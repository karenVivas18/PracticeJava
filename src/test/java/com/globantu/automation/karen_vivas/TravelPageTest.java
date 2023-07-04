package com.globantu.automation.karen_vivas;

import com.globantu.automation.karen_vivas.commun.DriverManager;
import com.globantu.automation.karen_vivas.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Driver;

public class TravelPageTest {
    DriverManager driver;
    private HomePage home;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new DriverManager(browser);
        home = new HomePage(driver.getDriver(), url);
    }

    @Test
    public void booking(){
        if (home.isUserLogged()){
            home.logOut();
        }
    }
}
