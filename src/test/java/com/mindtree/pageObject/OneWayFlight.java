package com.mindtree.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.OneWayFlightUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class OneWayFlight extends OneWayFlightUI {

    private WebDriver driver;
    private Logger log;
    private ExtentTest test;
    

    // default wait in milliseconds
    private static final int WAIT_TIME = 3000;

    public OneWayFlight(WebDriver driver, Logger log, ExtentTest test) {
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

    public void Frmplc(String fromCity) throws ReusableComponentException, InterruptedException {
        WebDriverSupport.click(driver, from, "Home Page", "From Field", log, test);
        waitForStep();
        WebDriverSupport.sendKeys(driver, frm, "From Field", "From Place Name", log, test, fromCity);
        waitForStep();
        WebDriverSupport.click(driver, By.xpath("//p[contains(text(),'" + fromCity + "')]"),
                "From Suggestions", fromCity, log, test);
        waitForStep();
    }

    public void Toplc(String toCity) throws ReusableComponentException, InterruptedException {
        WebDriverSupport.click(driver, to, "Home Page", "To Field", log, test);
        waitForStep();
        WebDriverSupport.sendKeys(driver, toField, "To Field", "To Place Name", log, test, toCity);        WebDriverSupport.click(driver, By.xpath("//p[contains(text(),'" + toCity + "')]"),
                "To Suggestions", toCity, log, test);
        waitForStep();
    }

    public void Seldt(String date) throws ReusableComponentException {
        WebDriverSupport.click(driver, datee, "Home Page", "Departure Date Picker", log, test);
        waitForStep();

        WebDriverSupport.click(driver, By.xpath("//div[@aria-label='" + date + "']"),
                "Date Picker", "Selected Date", log, test);
        waitForStep();

    }

    public void seltravellers(int adults, int children) throws ReusableComponentException {
        WebDriverSupport.click(driver, trav, "Home Page", "Travellers Dropdown", log, test);
        waitForStep();

        WebDriverSupport.click(driver, By.xpath("//li[@data-cy='adults-" + adults + "']"),
                "Travellers Dropdown", "Adults: " + adults, log, test);
        waitForStep();

        WebDriverSupport.click(driver, By.xpath("//li[@data-cy='children-" + children + "']"),
                "Travellers Dropdown", "Children: " + children, log, test);
        waitForStep();

        WebDriverSupport.click(driver, done, "Travellers Dropdown", "Apply", log, test);
        waitForStep();

    }

    public void travelclass(String travelClass) throws ReusableComponentException {
        WebDriverSupport.click(driver, trav, "Home Page", "Travellers Dropdown", log, test);
        waitForStep();

        int classIndex = travelClass.equalsIgnoreCase("Business") ? 3 : 1; // Map according to your UI
        WebDriverSupport.click(driver, By.xpath("//li[@data-cy='travelClass-" + classIndex + "']"),
                "Travel Class Dropdown", travelClass, log, test);
        waitForStep();

        WebDriverSupport.click(driver, done, "Travel Class Dropdown", "Apply", log, test);
        waitForStep();

    }

    public void srchflght() throws ReusableComponentException, IOException {
        WebDriverSupport.click(driver, srch, "Home Page", "Search Flight Button", log, test);
        waitForStep();
        WebDriverSupport.click(driver, cls, "Flight Page", "popup close Button", log, test);
        waitForStep();
        WebDriverSupport.click(driver, student, "Flight Page", "student option", log, test);
        waitForStep();
        WebDriverSupport.click(driver, indigo, "Flight Page", "indigo checkbox", log, test);
        waitForStep();
        WebDriverSupport.click(driver, tym, "Flight Page", "departure tym", log, test);
        waitForStep();
        WebDriverSupport.click(driver, fare, "Flight Page", "view fare", log, test);
        waitForStep();
        WebDriverSupport.click(driver, booknow, "Flights Pop up", "book now", log, test);
        waitForStep();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                ExtentLogUtilities.pass(driver, test, "Switched to new tab: " + driver.getTitle(), log);
                break;
            }
        }
        waitForStep();
        WebDriverSupport.click(driver, rules, "Booking page", "view fare rules", log, test);
        waitForStep();
        WebDriverSupport.click(driver, datechange, "Booking page", "date change charges", log, test);
        waitForStep();
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");

        WebDriverSupport.click(driver, close, "view rules popup", "close", log, test);
        waitForStep();
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");

        WebDriverSupport.click(driver, addbaggage, "Booking page", "add baggage", log, test);
        waitForStep();
        WebDriverSupport.click(driver, plus5, "add baggage popup", "plus 5", log, test);
        waitForStep();
        WebDriverSupport.click(driver, done1, "add baggage popup", "done", log, test);
        waitForStep();
        WebDriverSupport.click(driver, bestvalue, "special combos field", "best value option", log, test);
        waitForStep();
        WebDriverSupport.click(driver, viewbene, "trip secure field", "view all benefits", log, test);
        waitForStep();
        WebDriverSupport.click(driver, close, "view all benefits popup", "close", log, test);
        waitForStep();
        WebDriverSupport.click(driver, secure, "page", "secure my trip", log, test);
        waitForStep();
        WebDriverSupport.click(driver, contribute, "right side", "contribute", log, test);
        waitForStep();


    }
    public void booksdetails(String Mobileno,String Email,String BillingAddress,String Pincode) throws ReusableComponentException, InterruptedException {
    	WebDriverSupport.click(driver, mob, "Billing details", "Mobile no box", log, test);
        waitForStep();
        WebDriverSupport.sendKeys(driver, mob, "Mobile no field", "mobile no", log, test, Mobileno);
        waitForStep();
        WebDriverSupport.click(driver, email, "Billing details", "Email", log, test);
        waitForStep();
        WebDriverSupport.sendKeys(driver, email, "Email field", "Email", log, test, Email);
        waitForStep();
        /*WebElement addressElement = driver.findElement(address);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addressElement);
        Thread.sleep(500); // Wait for scroll animation to complete

        // Use Actions to move and click safely
        Actions actions = new Actions(driver);
        actions.moveToElement(addressElement).perform();
        Thread.sleep(300); // Small pause to ensure element is interactable
        actions.click().perform();
        waitForStep();*/

        WebDriverSupport.sendKeys(driver, address, "Billing Address field", "Billing Address", log, test, BillingAddress);
        waitForStep();

        waitForStep();
       // WebDriverSupport.click(driver, pincode, "Billing details", "Pincode", log, test);
        waitForStep();
        WebDriverSupport.sendKeys(driver, pincode, "Pincode field", "Pincode", log, test, Pincode);
        waitForStep();
        WebElement continuebt = driver.findElement(contue);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continuebt);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continuebt);

     //   WebDriverSupport.click(driver, contue, "Billing details", "Continue", log, test);

    }

    public void FlightPage() throws ReusableComponentException {
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
        }
    }
}
