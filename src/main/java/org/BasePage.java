package org;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public boolean findAndClick(By locator) {
        if (this.find(locator) != null) {
            this.find(locator).click();
            return true;
        }

        return false;
    }

    public boolean findAndType(By locator, String text) {
        if (this.find(locator) != null) {
            this.find(locator).sendKeys(text);
            return true;
        }

        return false;
    }

}
