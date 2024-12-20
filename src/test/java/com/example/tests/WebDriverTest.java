package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverTest {


    @Test
    public void navigateToPageUsingChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        options.setBrowserVersion("stable");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://omaya.blogspot.com");
        delay(5000);
        driver.quit();
    }

    @Test
    public void navigateToPageUsingFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.quit();
    }

    @Test
    public void navigateToPageUsingEdge() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://bing.com");
        driver.quit();
    }


    @Test
    public void navigateToPageUsingChromeManual() {
        System.setProperty("webdriver.chrome.driver", "path");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.quit();
    }

    private void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
