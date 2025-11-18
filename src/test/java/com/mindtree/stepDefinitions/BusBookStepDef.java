package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.pageObject.BusBook;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class BusBookStepDef {

    private WebDriver driver;
    private BusBook busbk;
    private Logger log = Logger.getLogger(BusBookStepDef.class);
    private ExtentTest test;

    @Before("@BusBook")
    public void setUp(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        busbk = new BusBook(driver, log, test);
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @Given("open website with URL")
    public void openWebsite() throws Exception {
        String url = Base.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("click on Signup window close in cabs")
    public void closeSignupPopup() throws IOException {
        try {
            busbk.clickCloseButton();
        } catch (ReusableComponentException e) {
            // Optional: log warning instead of failing test
            ExtentLogUtilities.fail(driver, test, "Signup popup not displayed, skipping close", log);
        }
    }
    
    @Then("Click on Bus")
    public void SelectTrains() throws ReusableComponentException {
    	busbk.Trains();
    }

    @And("Enter FromStop {string}")
    public void enterFromCity(String From) throws ReusableComponentException, InterruptedException {
        busbk.Frmplc(From);
    }
    
    @And("Enter ToStop {string}")
    public void enterToStation(String To) throws ReusableComponentException, InterruptedException {
        busbk.Toplc(To);
    }
    
    /*@Then("select Departure {string}")
    public void selectDepartureDate(String date) throws Exception {
        busbk.Seldt(date);
    }*/

   

    @Then("Click on Search Bus")
    public void searchTrains() throws ReusableComponentException, IOException {
        busbk.srchtrains();
    }
    
 
   // @And("If Flight page is displayed close it")
   // public void closeFlightPageIfDisplayed() throws ReusableComponentException, IOException {
     //  onewaycr.FlightPage();
    //}

    @After("@BusBook")
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
