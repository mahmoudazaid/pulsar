package com.orange.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features/*.feature",
    glue = {"com.orange"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cart-reports.html",
        "json:target/cucumber.json"
    },
    monochrome = true,
    tags = "@cart"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
} 