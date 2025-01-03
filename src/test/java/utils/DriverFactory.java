package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver initDriver(String browserType, String url) {
        WebDriver driver;

        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(url);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(url);
                break;
            case "edge":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(url);
                break;
            case "safari":
                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.get(url);
                break;
            default:
                throw new RuntimeException("Invalid browser type");
        }
        return driver;
    }


    public static void visualDelay(int delay) throws InterruptedException {
        Thread.sleep(delay);
    }
}
