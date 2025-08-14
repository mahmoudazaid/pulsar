package com.pulsar.cucumber.runner;

import com.pulsar.selenium.driver.CustomWebDriver;

public class TestState {
    private CustomWebDriver driver;

    public CustomWebDriver getDriver() {
        return driver;
    }

    public void setDriver(CustomWebDriver driver) {
        this.driver = driver;
    }
}
