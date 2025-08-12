package com.celonis.cucumber.stepDef;

import com.celonis.cucumber.runner.TestState;
import org.apache.log4j.Logger;

public class AbstractStepDef {
    protected static Logger logger;
    protected final TestState state;

    public AbstractStepDef(TestState state, String className) {
        logger = Logger.getLogger(className);
        logger.trace(className);
        this.state = state;
    }
}
