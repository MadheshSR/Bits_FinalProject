package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.pageObject.OneWayCar;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class OneWayCarStepDef {

    private WebDriver driver;
    private OneWayCar onewaycr;
    private Logger log = Logger.getLogger(OneWayCarStepDef.class);
    private ExtentTest test;

    @Before("@OneWayCar")
    public void setUp(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        onewaycr = new OneWayCar(driver, log, test);
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @Given("Open website with URL")
    public void openWebsite() throws Exception {
        String url = Base.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("Click on Signup window close in cabs")
    public void closeSignupPopup() throws IOException {
        try {
            onewaycr.clickCloseButton();
        } catch (ReusableComponentException e) {
            // Optional: log warning instead of failing test
            ExtentLogUtilities.fail(driver, test, "Signup popup not displayed, skipping close", log);
        }
    }
    
    @Then("Click on Cabs")
    public void SelectCabs() throws ReusableComponentException {
    	onewaycr.cabs();
    }

    @And("Enter Fromplace {string}")
    public void enterFromCity(String From) throws ReusableComponentException, InterruptedException {
        onewaycr.Frmplc(From);
    }


    @Then("Select departure datee")
    public void selectDepartureDate() throws ReusableComponentException {
        onewaycr.Seldt();
    }


    @Then("Click on Search Cabs")
    public void searchCabs() throws ReusableComponentException, IOException {
        onewaycr.srchcabs();
    }
    
 
   // @And("If Flight page is displayed close it")
   // public void closeFlightPageIfDisplayed() throws ReusableComponentException, IOException {
     //  onewaycr.FlightPage();
    //}

    @After("@OneWayCar")
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
