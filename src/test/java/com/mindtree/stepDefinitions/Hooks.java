package com.mindtree.stepDefinitions;

import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    private ExtentTest test;
    private Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                if (test != null) {
                    ExtentLogUtilities.fail(driver, test, "Scenario Failed: " + scenario.getName(), log);
                }
            } else {
                if (test != null) {
                    ExtentLogUtilities.pass(driver, test, "Scenario Passed: " + scenario.getName(), log);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (test != null) {
                Base.report.endTest(test);
                Base.report.flush();
                Base.quitDriver();
            }
            // Only quit driver at the very end, if needed
            // Base.quitDriver(); // optional if you want to close after each scenario
        }
    }
}
