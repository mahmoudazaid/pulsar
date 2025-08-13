package com.orange.selenium.driver;

import com.orange.selenium.locator.core.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWebDriver {
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

    public void sendKeysAndClear(By by, String text) {
        waitVisibilityOf(by, 120);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void clickOn(By by) {
        waitVisibilityOf(by, 120);
        driver.findElement(by).click();
    }

    public void clickOn(Locator locator) {
        clickOn(locator.by());
    }

    public boolean waitUntilTitleIs(String title, int timeOut) {
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.titleIs(title));
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

    public void waitPresenceOf(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitPresenceOf(Locator locator, int timeOut) {
        waitPresenceOf(locator.by(), timeOut);
    }

    public boolean isElementVisible(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public boolean isElementVisible(Locator locator) {
        return isElementVisible(locator.by());
    }

    public void scrollIntoView(By by) {
        scrollIntoView(by, 30);
    }

    public void scrollIntoView(By by, int timeOut) {
        waitPresenceOf(by, timeOut);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});", findElement(by)
        );
        waitVisibilityOf(by, timeOut);
    }

    public void scrollIntoView(Locator locator) {
        scrollIntoView(locator.by());
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public String getText(Locator locator) {
        return getText(locator.by());
    }

    public String getAttribute(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    public String getAttribute(Locator locator, String attribute) {
        return getAttribute(locator.by(), attribute);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement findElement(Locator locator) {
        return findElement(locator.by());
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
}
