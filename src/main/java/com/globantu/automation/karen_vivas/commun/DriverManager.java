package com.globantu.automation.karen_vivas.commun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;
    public DriverManager(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:/Users/karen.vivas/IdeaProjects/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }
    public WebDriver getDriver() {
        return this.driver;
    }
}
