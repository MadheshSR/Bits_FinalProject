package com.mindtree.pageObject;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.OneWayTrainUI;
import com.relevantcodes.extentreports.ExtentTest;

public class OneWayTrain extends OneWayTrainUI {

    private WebDriver driver;
    private Logger log;
    private ExtentTest test;
    

    // default wait in milliseconds
    private static final int WAIT_TIME = 3000;

    public OneWayTrain(WebDriver driver, Logger log, ExtentTest test) {
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
    
    public void Trains() throws ReusableComponentException {
        WebDriverSupport.click(driver, train, "Home Page", "Trains", log, test);

    }

    public void Frmplc(String fromCity) throws ReusableComponentException, InterruptedException {
        WebDriverSupport.click(driver, from, "Home Page", "From Field", log, test);
        waitForStep();
        WebDriverSupport.sendKeys(driver, frm, "From Field", "From Place Name", log, test, fromCity);
        waitForStep();
        WebDriverSupport.click(driver, frmst, "From Field", "From Place Name", log, test);
        waitForStep();
    }
    
    public void Toplc(String toCity) throws ReusableComponentException, InterruptedException {
        WebDriverSupport.click(driver, to, "Home Page", "To Field", log, test);
        waitForStep();
        WebDriverSupport.click(driver, toField, "To Field", "To Place Name", log, test);
        waitForStep();

        WebDriverSupport.click(driver, tost, "To Field", "To Place Name", log, test);
        waitForStep();
        WebDriverSupport.click(driver, tdy, "To Field", "To Place Name", log, test);

    }
    
    
    /*public void Seldt(String date) throws ReusableComponentException {
        WebDriverSupport.click(driver, datee, "Home Page", "Departure Date Picker", log, test);
        waitForStep();
        //WebDriverSupport.click(driver, dat, "Home Page", "Departure Date", log, test);

      WebDriverSupport.click(driver, By.xpath("//div[contains(@class,'styles_dayCmp__calDtVwWrp')]//p[text()='" + date + "']"),
               "Date Picker", "Selected Date", log, test);
        waitForStep();

    }*/


    public void srchtrains() throws ReusableComponentException, IOException {
        // Close any open popups (calendar)
        closeCalendarIfOpen();
        closeAutoSuggestIfOpen();

        // Scroll Search button into view (Important!)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
                driver.findElement(srchtr));
         waitForStep();
        // Now safely click Search Train button
        WebDriverSupport.click(driver, srchtr, "Home Page", "Search Train Button", log, test);
        waitForStep();
    }

    private void closeCalendarIfOpen() {
        try {
            // Calendar main container by its class (the intercepted element)
            By calendar = By.cssSelector("div.styles_calCmp__mainCnt__mM14w");

            if (driver.findElements(calendar).size() > 0) {
                System.out.println("Calendar found → trying to close...");

                // Press ESC twice
                new org.openqa.selenium.interactions.Actions(driver)
                        .sendKeys(org.openqa.selenium.Keys.ESCAPE)
                        .perform();

                Thread.sleep(800);

                // If still open → click on the body using JS
                if (driver.findElements(calendar).size() > 0) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("document.querySelector('body').click();");
                    Thread.sleep(800);
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Error closing calendar, continuing...");
        }
    }
    
    private void closeAutoSuggestIfOpen() {
        try {
            By autoList = By.cssSelector("li.sc-dExYaf.chSQox");

            if (driver.findElements(autoList).size() > 0) {
                System.out.println("Auto-suggest dropdown found → closing...");

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.activeElement.blur();");
                js.executeScript("document.querySelector('body').click();");

                Thread.sleep(700);
            }
        } catch (Exception e) {
            System.out.println("Error closing autosuggest dropdown, continuing...");
        }
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
