package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public By userInput = By.id("R1C1");
    public By passwordInput = By.id("R1C2");
    public By loginBtn = By.id("loginbtn");
    public By mainPageHeader = By.cssSelector("#kt_toolbar_container > div.page-title.d-flex.flex-column.me-3 > h1");
    public By errorMessage = By.cssSelector("#desc");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        this.findAndType(userInput,username);
        this.findAndType(passwordInput,password);
        this.findAndClick(loginBtn);
    }

}

