package com.celonis.cucumber.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {
                "com.celonis.cucumber.stepDef",
                "com.celonis.cucumber.hooks"
        },
        plugin = {
                "json:target/reports/cucumber/cucumber.json",
                "html:target/reports/cucumber/cucumber.html"
        }
)
public class TestRunner {
}
