package com.mindtree.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.ForexUI;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class Forex extends ForexUI {

    private WebDriver driver;
    private Logger log;
    private ExtentTest test;
    

    // default wait in milliseconds
    private static final int WAIT_TIME = 3000;

    public Forex(WebDriver driver, Logger log, ExtentTest test) {
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
    
    public void ins() throws ReusableComponentException, IOException {
        WebDriverSupport.click(driver, forex, "Home Page", "Forex", log, test);
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
        // Close the child window if it's open
        String currentWindow = driver.getWindowHandle();
        driver.close();
        waitForStep();


        // Switch back to main window if available
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            break;

    }
    }

}