package com.celonis.selenium.locator;

import com.celonis.selenium.locator.core.I18nLocator;
import com.celonis.selenium.locator.core.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public enum WorkspacesLocator implements Locator, I18nLocator {
    ALL_WORKSPACES(By.linkText("All Workspaces")),
    WORKSPACES("//span[contains(text(),'%s')]"),
    ANALYSES("//h3[contains(text(),'%s')]"),
    CHART_ANALYSES("//h3[contains(text(),'%s')]/../../../..//a"),
    ANALYSES_MENUE(By.cssSelector("div.analysis-menu"));

    static Logger logger = Logger.getLogger(WorkspacesLocator.class.getName());
    private By locator;
    private String key;


    WorkspacesLocator(By locator) {
        this.locator = locator;
    }

    WorkspacesLocator(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public By by() {
        logger.trace("locator");
        if (this.getKey() == null) {
            return locator;
        } else {
            return By.xpath(this.getKey());
        }
    }

    @Override
    public By by(Object... index) {
        logger.trace("selector");
        return (By.xpath(String.format(key, index)));
    }
}
