package com.celonis.cucumber.stepDef;

import com.celonis.constants.User;
import com.celonis.cucumber.runner.TestState;
import com.celonis.selenium.page.LogInPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LoginStepDef extends AbstractStepDef {
    public LoginStepDef(TestState state) {
        super(state, LoginStepDef.class.getName());
    }

    @Given("^the user is logged with \"([^\"]*)\"$")
    public void loginByUserName(String user) throws Throwable {
        LogInPage logInPage = new LogInPage(state.getDriver());
        User userData = User.getUserByName(user);
        logInPage.writeEmail(userData.getUserEmail())
                .writePassword(userData.getPassword())
                .clickSignIn();
    }

    @Then("^the user should view the following sections$")
    public void verifyPageSectionsDisplayed(DataTable table) {
        LogInPage logInPage = new LogInPage(state.getDriver());
        table.asList(String.class).forEach(element -> {
            Assert.assertTrue(element + " not displayed on the page ", logInPage.isSectionDisplayed(element));
        });
    }

    @Given("^user write \"([^\"]*)\" into email field and \"([^\"]*)\" into password field$")
    public void login(String email,String password){
        LogInPage logInPage = new LogInPage(state.getDriver());
        logInPage.writeEmail(email)
                .writePassword(password)
                .clickSignIn();
    }
}
