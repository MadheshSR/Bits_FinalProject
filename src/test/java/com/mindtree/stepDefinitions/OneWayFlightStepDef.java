package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.pageObject.OneWayFlight;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class OneWayFlightStepDef {

    private WebDriver driver;
    private OneWayFlight onewayfl;
    private Logger log = Logger.getLogger(OneWayFlightStepDef.class);
    private ExtentTest test;

    @Before("@OneWayFlight")
    public void setUp(Scenario scenario) throws Exception {
        driver = Base.getDriver(); // Reuse single driver
        test = Base.report.startTest(scenario.getName());
        onewayfl = new OneWayFlight(driver, log, test);
        ExtentLogUtilities.pass(driver, test, "Scenario started: " + scenario.getName(), log);
    }

    @Given("Open Website with URL")
    public void openWebsite() throws Exception {
        String url = Base.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("Click on Signup window close")
    public void closeSignupPopup() throws IOException {
        try {
            onewayfl.clickCloseButton();
        } catch (ReusableComponentException e) {
            // Optional: log warning instead of failing test
            ExtentLogUtilities.fail(driver, test, "Signup popup not displayed, skipping close", log);
        }
    }

    @And("Enter From {string}")
    public void enterFromCity(String From) throws ReusableComponentException, InterruptedException {
        onewayfl.Frmplc(From);
    }

    @And("Enter To {string}")
    public void enterToCity(String To) throws ReusableComponentException, InterruptedException {
        onewayfl.Toplc(To);
    }

    @Then("Select departure date {string}")
    public void selectDepartureDate(String date) throws ReusableComponentException {
        onewayfl.Seldt(date);
    }

    @And("Select travellers {int} adults and {int} children")
    public void selectTravellers(int adults, int children) throws ReusableComponentException {
        onewayfl.seltravellers(adults, children);
    }

    @And("Select TravelClass {string}")
    public void selectTravelClass(String travelClass) throws ReusableComponentException {
        onewayfl.travelclass(travelClass);
    }

    @Then("Click on Search Flights")
    public void searchFlights() throws ReusableComponentException, IOException {
        onewayfl.srchflght();
    }
    
    @Then("Enter Booking Details {string},{string},{string},{string}")
    public void BookingDetails(String Mobileno,String Email,String BillingAddress,String Pincode) throws ReusableComponentException, InterruptedException {
    	onewayfl.booksdetails(Mobileno,Email,BillingAddress,Pincode);
    }
    
    @And("If Flight page is displayed close it")
    public void closeFlightPageIfDisplayed() throws ReusableComponentException, IOException {
       onewayfl.FlightPage();
    }

    @After("@OneWayFlight")
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
