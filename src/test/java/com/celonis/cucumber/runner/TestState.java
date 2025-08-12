package com.celonis.cucumber.runner;

import com.celonis.selenium.driver.CustomWebDriver;

public class TestState {
    private CustomWebDriver driver;

    public CustomWebDriver getDriver() {
        return driver;
    }


    public void setDriver(CustomWebDriver driver) {
        this.driver = driver;
    }
}
