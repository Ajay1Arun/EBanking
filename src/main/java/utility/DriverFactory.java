package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            String headless = ConfigReader.getProperty("headless");
            boolean isHeadless = headless != null && headless.equalsIgnoreCase("true");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (isHeadless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                if (isHeadless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                }
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
