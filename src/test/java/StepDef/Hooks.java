package StepDef;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.DriverFactory;
import utility.ExtentManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.getDriver();
        extent = ExtentManager.getExtentReports();
        test = extent.createTest(scenario.getName());
        ExtentManager.setTest(test);
        driver.get(utility.ConfigReader.getProperty("url"));
        test.log(Status.INFO, "Navigated to " + utility.ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String screenshotPath = "src/test/resources/screenshots/" + scenario.getName() + "_" + System.currentTimeMillis() + ".png";
            try {
                Files.createDirectories(Paths.get("src/test/resources/screenshots/"));
                Files.copy(source.toPath(), Paths.get(screenshotPath));
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.log(Status.FAIL, "Scenario failed: " + scenario.getName());
        } else {
            test.log(Status.PASS, "Scenario passed: " + scenario.getName());
        }
        DriverFactory.closeDriver();
        extent.flush();
    }
}
