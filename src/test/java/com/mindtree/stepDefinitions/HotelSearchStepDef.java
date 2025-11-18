package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.pageObject.HotelSearch;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class HotelSearchStepDef {

    private WebDriver driver;
    private HotelSearch hotelsr;
    private Logger log = Logger.getLogger(HotelSearchStepDef.class);
    private ExtentTest test;

    @Before("@HotelSearch")
    public void setUp(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        hotelsr = new HotelSearch(driver, log, test);
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @Given("Open Website With URL")
    public void openWebsite() throws Exception {
        String url = Base.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("Click On Signup Window Close in Hotels")
    public void closeSignupPopup() throws IOException {
        try {
            hotelsr.clickCloseButton();
        } catch (ReusableComponentException e) {
            // Optional: log warning instead of failing test
            ExtentLogUtilities.fail(driver, test, "Signup popup not displayed, skipping close", log);
        }
    }
    
    @Then("Click on Hotels")
    public void SelectTrains() throws ReusableComponentException {
    	hotelsr.Hotels();
    }

    @And("Enter {string}")
    public void enter(String From) throws ReusableComponentException, InterruptedException {
        hotelsr.Frmplc(From);
    }
    

   

    @Then("Click on search Hotels")
    public void searchTrains() throws ReusableComponentException, IOException {
        hotelsr.srchhotels();
    }
    
 
   // @And("If Flight page is displayed close it")
   // public void closeFlightPageIfDisplayed() throws ReusableComponentException, IOException {
     //  onewaycr.FlightPage();
    //}

    @After("@HotelSearch")
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
