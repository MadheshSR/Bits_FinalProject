package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.pageObject.OneWayTrain;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class OneWayTrainStepDef {

    private WebDriver driver;
    private OneWayTrain onewaytr;
    private Logger log = Logger.getLogger(OneWayTrainStepDef.class);
    private ExtentTest test;

    @Before("@OneWayTrain")
    public void setUp(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        onewaytr = new OneWayTrain(driver, log, test);
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @Given("Open website with url")
    public void openWebsite() throws Exception {
        String url = Base.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("Click on Signup window close in trains")
    public void closeSignupPopup() throws IOException {
        try {
            onewaytr.clickCloseButton();
        } catch (ReusableComponentException e) {
            // Optional: log warning instead of failing test
            ExtentLogUtilities.fail(driver, test, "Signup popup not displayed, skipping close", log);
        }
    }
    
    @Then("Click on Trains")
    public void SelectTrains() throws ReusableComponentException {
    	onewaytr.Trains();
    }

    @And("Enter FromStation {string}")
    public void enterFromCity(String From) throws ReusableComponentException, InterruptedException {
        onewaytr.Frmplc(From);
    }
    
    @And("Enter ToStation {string}")
    public void enterToStation(String To) throws ReusableComponentException, InterruptedException {
        onewaytr.Toplc(To);
    }
    
   /* @Then("select Departure {string}")
    public void selectDepartureDate(String date) throws Exception {
        onewaytr.Seldt(date);
    }*/

   

    @Then("Click on Search Trains")
    public void searchTrains() throws ReusableComponentException, IOException {
        onewaytr.srchtrains();
    }
    
 
   // @And("If Flight page is displayed close it")
   // public void closeFlightPageIfDisplayed() throws ReusableComponentException, IOException {
     //  onewaycr.FlightPage();
    //}

    @After("@OneWayTrain")
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
