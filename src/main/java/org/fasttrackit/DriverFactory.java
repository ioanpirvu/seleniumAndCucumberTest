package org.fasttrackit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver(String browser) {

        WebDriver driver;
        switch (browser) {
            default:
                System.out.println ("Using default browser: Chrome.");
            case "chrome":
                System.setProperty ("web driver.chrome.driver", AppConfig.getChromeDriverPath ( ));
                driver = new ChromeDriver ( );
                break;
            case "firefox":
                System.setProperty ("web driver.ie.driver", AppConfig.getGeckoDriverPath ( ));
                driver = new FirefoxDriver ( );
                break;
            case "ie":
                System.setProperty ("web driver.gecko.driver", AppConfig.getInternetExplorerDriverPath ( ));
                driver = new InternetExplorerDriver ( );
                break;


        }

        driver.manage ( ).window ( ).maximize ( );
        driver.manage ( ).timeouts ( ).implicitlyWait (5, TimeUnit.SECONDS);

        DriverFactory.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
