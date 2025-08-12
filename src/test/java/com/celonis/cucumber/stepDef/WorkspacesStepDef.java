package com.celonis.cucumber.stepDef;

import com.celonis.cucumber.runner.TestState;
import com.celonis.selenium.page.WorkspacesPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WorkspacesStepDef extends AbstractStepDef {
    public WorkspacesStepDef(TestState state) {
        super(state, WorkspacesStepDef.class.getName());
    }

    @Then("^the user should view the following demo workspaces")
    public void verifyPageSectionsDisplayed(DataTable table) {
        WorkspacesPage workspacesPage = new WorkspacesPage(state.getDriver());
        table.asList(String.class).forEach(element -> {
            Assert.assertTrue(element + " workspace not displayed on the page ", workspacesPage.isWorkspacesDisplayed(element));
        });
    }

    @When("^user click on all workspaces$")
    public void userClickOnAllWorkspaces() {
        WorkspacesPage workspacesPage = new WorkspacesPage(state.getDriver());
        workspacesPage.clickOnAllWorkSpaces();
    }

    @Then("^the user should view the following demo analyses$")
    public void theUserShouldViewTheFollowingDemoAnalyses(DataTable table) {
        WorkspacesPage workspacesPage = new WorkspacesPage(state.getDriver());
        table.asList(String.class).forEach(element -> {
            Assert.assertTrue(element + " analyses not displayed on the page ", workspacesPage.isAnalysesDisplayed(element));
        });
    }

    @When("^user open \"([^\"]*)\" chart$")
    public void userOpenChart(String chartName) throws Throwable {
        WorkspacesPage workspacesPage = new WorkspacesPage(state.getDriver());
        workspacesPage.openChart(chartName);
    }

    @Then("^the chart analyses page is opened$")
    public void theChartPageIsOpened() {
        WorkspacesPage workspacesPage = new WorkspacesPage(state.getDriver());
        Assert.assertTrue("Chart page not opened",workspacesPage.isChartAnalysesPageOpened());
    }
}
