package com.pulsar.selenium.driver;

import com.pulsar.utils.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

    private static final String BROWSER = getBrowserWithFallback();

    private static String getBrowserWithFallback() {
        try {
            return SystemProperties.getSeleniumBrowser();
        } catch (Exception e) {
            // Fallback to chrome if system.properties is not available
            return "CHROME";
        }
    }

    private static boolean isHeadless() {
        try {
            String headless = SystemProperties.getProperty("headless");
            return "true".equalsIgnoreCase(headless);
        } catch (Exception e) {
            return false; // Default to non-headless
        }
    }

    public static CustomWebDriver getBrowser() {
        WebDriver driver;
        switch (BROWSER.toUpperCase()) {
            case "CHROME":
                driver = getChromeDriver();
                break;
            case "FIREFOX":
                driver = getFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(BROWSER + " not supported");
        }
        driver.manage().window().maximize();
        return new CustomWebDriver(driver);
    }

    private static WebDriver getChromeDriver() {
        // Use WebDriverManager 5.x to automatically download and setup the correct ChromeDriver version
        WebDriverManager.chromedriver().setup();
        
        // Create ChromeOptions for better compatibility
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        
        // Add headless mode if configured
        if (isHeadless()) {
            options.addArguments("--headless");
        }
        
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new org.openqa.selenium.firefox.FirefoxDriver();
    }
}
