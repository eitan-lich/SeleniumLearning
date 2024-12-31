package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

    }

    @Test
    public void testDropdown() throws InterruptedException {

        driver.findElement(By.linkText("Dropdown")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdownEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        Select select = new Select(dropdownEle);

        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2500);
        select.selectByIndex(2);
        Thread.sleep(2500);
        select.selectByValue("1");
        Thread.sleep(2500);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
