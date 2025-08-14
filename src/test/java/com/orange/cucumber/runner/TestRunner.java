package com.orange.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Main Test Runner - Runs both UI and API tests
 * For specific test types, use:
 * - UICucumberRunner for UI tests only
 * - APICucumberRunner for API tests only
 */
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.orange.cucumber.stepDef.ui", "com.orange.cucumber.stepDef.api", "com.orange.cucumber.hooks.UIGlobalHooks", "com.orange.cucumber.hooks.UIScenarioHooks", "com.orange.cucumber.hooks.APIGlobalHooks", "com.orange.cucumber.hooks.APIScenarioHooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/combined-cucumber.html",
        "json:target/cucumber-reports/combined-cucumber.json",
        "junit:target/cucumber-reports/combined-cucumber.xml"
    },
    monochrome = true,
    tags = "not @ignore"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
} 