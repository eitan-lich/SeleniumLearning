import org.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HandesaimTelAvivSanity {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HandesaimTelAvivSanity.class);
    private LoginPage loginPage;

    @BeforeSuite
    public void setup() {
        logger.info("Starting test suite...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void visitStartingPage() {
        Properties props = new Properties();
        try (FileInputStream fs = new FileInputStream("src/main/resources/config.properties")) {
            props.load(fs);
            driver.get(props.getProperty("url"));
            logger.info("Navigating to: {}", props.getProperty("url"));
            loginPage = new LoginPage(driver);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void successfulLogin() {
        logger.info("Running...");
        loginPage.login(System.getenv("AUTOMATION_USERNAME"), System.getenv("AUTOMATION_PASSWORD"));
        String headerTitle = loginPage.find(loginPage.mainPageHeader).getText();
        Assert.assertEquals(headerTitle, "הנדסאים תל אביב - תחנת מידע");
        logger.info("PASSED");
    }

    @Test
    public void unsuccessfulLogin() {
        logger.info("Running...");
        loginPage.login(System.getenv("AUTOMATION_USERNAME"), System.getenv("AUTOMATION_WRONG_PASSWORD"));
        String errorMsgString = loginPage.find(loginPage.errorMessage).getText();
        Assert.assertEquals(errorMsgString, "הסיסמה או תעודה הזהות שהוקלדה שגויה (קוד 6) יש לשים לב, זוהי כניסת סטודנט\n" +
                "לחץ back ונסה שנית");
        logger.info("PASSED");
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
