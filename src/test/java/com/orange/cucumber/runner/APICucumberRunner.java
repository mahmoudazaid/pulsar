package com.orange.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features/api",
    glue = {"com.orange.cucumber.stepDef.api", "com.orange.cucumber.hooks.APIGlobalHooks", "com.orange.cucumber.hooks.APIScenarioHooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/api-cucumber.html",
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