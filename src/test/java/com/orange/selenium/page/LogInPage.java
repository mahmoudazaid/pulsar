package com.orange.selenium.page;

import com.orange.selenium.driver.CustomWebDriver;
import com.orange.selenium.page.core.PageObject;
import static com.orange.selenium.locator.LoginPageLocator.*;

public class LogInPage extends PageObject {
    public LogInPage(CustomWebDriver driver) {
        super(driver, LogInPage.class.getName());
    }

    public LogInPage writeEmail(String userEmail) {
        driver.sendKeysAndClear(EMAIL, userEmail);
        return this;
    }

    public LogInPage writePassword(String password) {
        driver.sendKeysAndClear(PASSWORD, password);
        return this;
    }

    public void clickSignIn() {
        driver.clickOn(SIGNIN);
    }

    public boolean isSectionDisplayed(String element) {
        driver.waitVisibilityOf(PAGE_SECTION.by(element),120);
        return driver.isElementVisible(PAGE_SECTION.by(element));
    }
}
