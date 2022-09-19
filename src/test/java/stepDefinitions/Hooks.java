package stepDefinitions;


import configuration.ReadConfigFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


import static com.learning.base.Baseclass.closeBrowser;
import static com.learning.base.Baseclass.launchbrowser;


public class Hooks {
    public static WebDriver driver;


    @Before(order=1)
    public void initializeTest() {
        System.out.println("Start the browser and Clear the cookies");
        launchbrowser();
    }

    @Before(order=0)
    public void beforeScenarioStart(Scenario scenario) {
        System.out.println("-----------------Start of Scenario-----------------");
        //DbConnection
    }

    @After(order=0)
    public void afterScenarioFinish() {
        System.out.println("-----------------End of Scenario-----------------");
    }

    @After(order=1)
    public void afterScenario(Scenario scenario) {
        System.out.println("Log out the user and close the browser");
        if (scenario.isFailed()) {

            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }
        closeBrowser();
    }






}
