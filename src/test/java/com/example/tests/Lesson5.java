package com.example.tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.DriverFactory;

import java.util.Set;

public class Lesson5 {

    private final String URL = "https://testpages.eviltester.com/styled/cookies/adminlogin.html";
    private WebDriver driver;


    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.initDriver("chrome", URL);
    }

    @Test(priority = 1)
    public void addCookie() {
        Cookie cookie = new Cookie("loggedin", "Admin");
        driver.manage().addCookie(cookie);

        Set<Cookie> cookies = driver.manage().getCookies();
        Assert.assertNotNull(cookies);
    }


    @Test(priority = 2)
    public void validateCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie.toString());
        }

        Assert.assertNotNull(driver.manage().getCookieNamed("loggedin"));
    }

    @Test(priority = 3)
    public void validateAdminCookie() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();

        driver.navigate().refresh();

        String newUrl = driver.getCurrentUrl();
        DriverFactory.visualDelay(3000);

        Assert.assertNotEquals(currentUrl, newUrl);
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
