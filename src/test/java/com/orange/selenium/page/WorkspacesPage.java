package com.orange.selenium.page;

import com.orange.selenium.driver.CustomWebDriver;
import com.orange.selenium.page.core.PageObject;

import static com.orange.selenium.locator.WorkspacesLocator.*;

public class WorkspacesPage extends PageObject {
    public WorkspacesPage(CustomWebDriver driver) {
        super(driver, WorkspacesPage.class.getName());
    }

    public boolean isWorkspacesDisplayed(String element) {
        driver.waitVisibilityOf(WORKSPACES.by(element), 120);
        return driver.isElementVisible(WORKSPACES.by(element));
    }

    public void clickOnAllWorkSpaces() {
        driver.clickOn(ALL_WORKSPACES);
    }

    public boolean isAnalysesDisplayed(String element) {
        driver.waitVisibilityOf(ANALYSES.by(element), 120);
        return driver.isElementVisible(ANALYSES.by(element));
    }

    public void openChart(String chartName) {
        driver.waitVisibilityOf(CHART_ANALYSES.by(chartName), 120);
        driver.clickOn(CHART_ANALYSES.by(chartName));
    }

    public boolean isChartAnalysesPageOpened() {
        driver.waitVisibilityOf(ANALYSES_MENUE, 120);
        return driver.isElementVisible(ANALYSES_MENUE.by());
    }
}
