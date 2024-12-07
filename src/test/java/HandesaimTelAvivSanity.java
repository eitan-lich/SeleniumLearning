import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HandesaimTelAvivSanity {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HandesaimTelAvivSanity.class);


    @BeforeSuite
    public void setup() {
        logger.info("Starting test suite...");
        Properties props = new Properties();
        try (FileInputStream fs = new FileInputStream("src/main/resources/config.properties")){
            props.load(fs);

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(props.getProperty("url"));
            logger.info("Navigating to: {}", props.getProperty("url"));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        logger.info("Running...");
        By userInput = By.id("R1C1");
        By passwordInput = By.id("R1C2");
        By loginBtn = By.id("loginbtn");
        By mainPageHeader = By.cssSelector("#kt_toolbar_container > div.page-title.d-flex.flex-column.me-3 > h1");

        driver.findElement(userInput).sendKeys(System.getenv("AUTOMATION_USERNAME"));
        driver.findElement(passwordInput).sendKeys(System.getenv("AUTOMATION_PASSWORD"));
        driver.findElement(loginBtn).click();
        String headerTitle = driver.findElement(mainPageHeader).getText();
        Assert.assertEquals(headerTitle, "הנדסאים תל אביב - תחנת מידע");
        logger.info("Test passed...");
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
