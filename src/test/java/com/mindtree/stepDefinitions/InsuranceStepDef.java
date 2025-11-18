package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.pageObject.Insurance;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class InsuranceStepDef {

    private WebDriver driver;
    private Insurance insuran;
    private Logger log = Logger.getLogger(InsuranceStepDef.class);
    private ExtentTest test;

    @Before("@Insurance")
    public void setUp(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        insuran = new Insurance(driver, log, test);
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @Given("open the website with URL")
    public void openWebsite() throws Exception {
        String url = Base.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("click on Signup window close in home")
    public void closeSignupPopup() throws IOException {
        try {
            insuran.clickCloseButton();
        } catch (ReusableComponentException e) {
            // Optional: log warning instead of failing test
            ExtentLogUtilities.fail(driver, test, "Signup popup not displayed, skipping close", log);
        }
    }
    
    @Then("Click on Insurance")
    public void SelectInsurance() throws ReusableComponentException {
    	insuran.ins();
    }

    
    @After("@Insurance")
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
