package com.pulsar.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features/api",
    glue = {"com.pulsar.cucumber.stepDef.api", "com.pulsar.cucumber.hooks.api"},
    plugin = {
        "pretty",
        "json:target/cucumber-reports/api-cucumber.json",
        "junit:target/cucumber-reports/api-cucumber.xml"
    },
    monochrome = true,
    tags = "@api"
)
public class APICucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
} 