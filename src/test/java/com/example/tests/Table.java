package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Table {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

    }

    @Test
    public void testDropdown() throws InterruptedException {

        driver.findElement(By.linkText("Sortable Data Tables")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdownEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table1")));

        List<WebElement> rows = dropdownEle.findElements(By.tagName("tr"));

        int i = 0;
        for (WebElement row : rows) {
            if (i > 0) {
                System.out.println("Row number: " + i + ", details: " + row.getText());
                List<WebElement> cells = row.findElements(By.tagName("td"));
                int j = 1;
                for (WebElement cell : cells) {
                    System.out.println("Cell number: " + j + ", details: " + cell.getText());
                    j++;
                }
            }
            i++;
        }

        Thread.sleep(2500);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
