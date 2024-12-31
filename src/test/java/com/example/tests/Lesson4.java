package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lesson4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationplayground.com/crm/");

        WebElement signInButton = driver.findElement(By.id("SignIn"));
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-id")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-id")));

        emailInput.sendKeys("test@test.com");
        passwordInput.sendKeys("123456");
        submitButton.click();

        WebElement newCustomerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-customer")));
        newCustomerButton.click();


        WebElement newCustomerEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EmailAddress")));
        WebElement newCustomerFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        WebElement newCustomerLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName")));
        WebElement newCustomerCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("City")));
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
        Thread.sleep(5000);
        WebElement newCustomerSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));


        newCustomerEmail.sendKeys(("tester@testing.com"));
        newCustomerFirstName.sendKeys("Joe");
        newCustomerLastName.sendKeys("Shmo");
        newCustomerCity.sendKeys("Tokyo");
        newCustomerSubmit.click();

        Thread.sleep(3000);


        
        driver.quit();
    }
}
