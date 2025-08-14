package com.orange.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features/ui",
    glue = {"com.orange.cucumber.stepDef.ui", "com.orange.cucumber.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/ui-cucumber.html",
        "json:target/cucumber-reports/ui-cucumber.json",
        "junit:target/cucumber-reports/ui-cucumber.xml"
    },
    monochrome = true,
    tags = "@ui or @cart",
    dryRun = false
)
public class UICucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
} 