package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowDemo {

    private WebDriver driver;

    @Test
    public void windowDemoing() {
        driver = new ChromeDriver();
        driver.get("https://www.google.co.il");

        String firstHandle = driver.getWindowHandle();
        System.out.println("First handle is: " + firstHandle);
        delay();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://aliexpress.com");
        delay();

        int i = 1;
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            System.out.println("Handle: " + i + " " + handle);
            i++;
        }
        delay();

        driver.switchTo().window(firstHandle);
        delay();
    }

    private void delay() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
