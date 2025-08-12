package com.celonis.selenium.driver;

import com.celonis.selenium.locator.core.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomWebDriver {
    private static final Logger logger = Logger.getLogger(CustomWebDriver.class.getName());
    private final WebDriver driver;

    public CustomWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        driver.quit();
    }

    public WebDriver getSeleniumWebDriver() {
        return driver;
    }

    public void goToUrl(String URL) {
        driver.navigate().to(URL);
    }

    public void sendKeysTo(Locator locator, String text) {
        waitVisibilityOf(locator, 120);
        driver.findElement(locator.by()).sendKeys(text);
    }

    public void sendKeysAndClear(Locator locator, String text) {
        waitVisibilityOf(locator, 120);
        driver.findElement(locator.by()).clear();
        sendKeysTo(locator, text);
    }

    public void clickOn(By by) {
        waitVisibilityOf(by, 120);
        driver.findElement(by).click();
    }

    public void clickOn(Locator locator) {
        clickOn(locator.by());
    }

    public void waitVisibilityOf(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitVisibilityOf(Locator locator, int timeOut) {
        waitVisibilityOf(locator.by(), timeOut);
    }

    public void waitInvisibilityOf(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitInvisibilityOf(Locator locator, int timeOut) {
        waitInvisibilityOf(locator.by(), timeOut);
    }

    public boolean isElementVisible(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
}
