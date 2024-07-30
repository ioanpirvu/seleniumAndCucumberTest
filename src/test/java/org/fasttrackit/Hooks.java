package org.fasttrackit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        String browser = System.getProperty ("browser", "chrome");
        DriverFactory.initDriver (browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed ()) {
            scenario.attach(((TakesScreenshot) DriverFactory.getDriver ( )).getScreenshotAs (OutputType.BYTES), "image/png");
        }

        DriverFactory.getDriver().quit();
    }
}
