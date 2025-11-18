package com.mindtree.pageObject;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.HotelSearchUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class HotelSearch extends HotelSearchUI {

    private WebDriver driver;
    private Logger log;
    private ExtentTest test;
    

    // default wait in milliseconds
    private static final int WAIT_TIME = 3000;

    public HotelSearch(WebDriver driver, Logger log, ExtentTest test) {
        this.driver = driver;
        this.log = log;
        this.test = test;
    }
    
    // utility wait method
    @SuppressWarnings("unused")
	private void waitForStep() {
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickCloseButton() throws ReusableComponentException {
        WebDriverSupport.click(driver, closeButton, "Signup Popup", "Close Button", log, test);
        waitForStep();

    }
    
    public void Hotels() throws ReusableComponentException {
        WebDriverSupport.click(driver, Hotel, "Home Page", "Hotels", log, test);
        try {
            if (driver.findElement(txt).isDisplayed()) {
                ExtentLogUtilities.pass(driver, test, "Hotels booking page verified", log);

            }
            
           else {
                throw new ReusableComponentException("Hotel page not displayed!");
            }
        } catch (Exception e) {
            throw new ReusableComponentException("Error while loading Hotel page: " + e.getMessage());
        }

    }

    public void Frmplc(String fromCity) throws ReusableComponentException, InterruptedException {
        WebDriverSupport.click(driver, from, "Home Page", "From Field", log, test);
        waitForStep();
        WebDriverSupport.sendKeys(driver, frm, "From Field", "From Place Name", log, test, fromCity);
        waitForStep();
        WebDriverSupport.click(driver, By.xpath("//p[contains(text(),'" + fromCity + "')]"),
                "From Suggestions", fromCity, log, test);
        //WebDriverSupport.click(driver, frmst, "From Field", "From Place Name", log, test);
        waitForStep();
    }
    
    
    /*public void Seldt(String date) throws ReusableComponentException {
        WebDriverSupport.click(driver, datee, "Home Page", "Departure Date Picker", log, test);
        waitForStep();

        WebDriverSupport.click(driver, By.xpath("//div[@aria-label='" + date + "']"),
                "Date Picker", "Selected Date", log, test);
        waitForStep();

    }*/


    public void srchhotels() throws ReusableComponentException, IOException {
        //((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");

       // WebDriverSupport.click(driver, datee, "Home Page", "Search Train Button", log, test);

        WebDriverSupport.click(driver, srch, "Home Page", "Search Hotel Button", log, test);
        waitForStep();
    }

    /*public void FlightPage() throws ReusableComponentException {
        try {
            if (driver.findElement(txt).isDisplayed()) {
                ExtentLogUtilities.pass(driver, test, "Flight booking page verified", log);

                // Close the child window if it's open
                String currentWindow = driver.getWindowHandle();
                driver.close();

                // Switch back to main window if available
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                    break;
                }

                WebDriverSupport.click(driver, clso, "Flight results box", "Close", log, test);
                WebDriverSupport.click(driver, getHome, "Flight Page", "Home Icon", log, test);
            } else {
                throw new ReusableComponentException("Flight page not displayed!");
            }
        } catch (Exception e) {
            throw new ReusableComponentException("Error while closing flight page: " + e.getMessage());
        }*/
    }
