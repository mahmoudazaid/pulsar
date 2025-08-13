package com.orange.cucumber.stepDef;

import com.orange.cucumber.runner.TestState;
import com.orange.selenium.page.HomePage;
import com.orange.utils.SystemProperties;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;

public class HomeStepDef extends AbstractStepDef {
    
    private static final Logger logger = Logger.getLogger(HomeStepDef.class.getName());
    private HomePage homePage;

    public HomeStepDef(TestState state) {
        super(state, HomeStepDef.class.getName());
        try {
            this.homePage = new HomePage(state.getDriver());
        } catch (Exception e) {
            logger.warn("Could not initialize HomePage in constructor: " + e.getMessage());
        }
    }

    private HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(state.getDriver());
        }
        return homePage;
    }

    @Given("I am on the StackDemo Home Page")
    public void iAmOnTheStackDemoHomePage() {
        logger.info("Navigating to StackDemo Home Page");
        String expectedUrl = SystemProperties.getApplicationUrl();
//        getHomePage().goToHomePage(expectedUrl);
        
        // Wait for homepage to load and verify
        getHomePage().waitForHomePageToLoad();
    }
} 