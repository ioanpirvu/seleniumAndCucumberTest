package org.fasttrackit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final Properties properties = new Properties ( );

    static {
        String environment = System.getProperty ("env", "production");
        InputStream inputStream = AppConfig.class.getClassLoader ( ).getResourceAsStream (environment + ".properties");

        try {
            properties.load (inputStream);
        } catch (IOException e) {
            System.out.println ("Failed to load properties from configuration file.");
        }
    }

    private static final String chromeDriverPath = properties.getProperty ("chrome.driver.path");
    private static final String geckoDriverPath = properties.getProperty ("gecko.driver.path");
    private static final String internetExplorerDriverPath = properties.getProperty ("ie.driver.path");
    private static final String siteUrl = properties.getProperty ("site.url");

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getInternetExplorerDriverPath() {
        return internetExplorerDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }
}
