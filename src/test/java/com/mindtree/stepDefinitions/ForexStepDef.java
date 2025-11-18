package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.pageObject.Forex;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class ForexStepDef {

    private WebDriver driver;
    private Forex forx;
    private Logger log = Logger.getLogger(ForexStepDef.class);
    private ExtentTest test;

    @Before("@Forex")
    public void setUp(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        forx = new Forex(driver, log, test);
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @Given("Open the website with URL")
    public void openWebsite() throws Exception {
        String url = Base.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("click on Signup window close in Home")
    public void closeSignupPopup() throws IOException {
        try {
            forx.clickCloseButton();
        } catch (ReusableComponentException e) {
            // Optional: log warning instead of failing test
            ExtentLogUtilities.fail(driver, test, "Signup popup not displayed, skipping close", log);
        }
    }
    
    @Then("Click on Forex")
    public void SelectInsurance() throws ReusableComponentException, IOException {
    	forx.ins();
    }

    
    @After("@Forex")
    public void tearDown() {
        try {
            if (test != null) {
                Base.report.endTest(test);
                Base.report.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
