package com.mindtree.reusableComponent;

import com.mindtree.exceptions.ReusableComponentException;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mindtree.utilities.ExtentLogUtilities;

public class WebDriverSupport {

    private static WebElement waitForElement(WebDriver driver, By locator, Logger log, ExtentTest test) throws ReusableComponentException {
        try {
            return new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            safeFail(driver, test, "Element not visible: " + locator, log);
            throw new ReusableComponentException("Element not visible: " + locator, e);
        }
    }

    public static void click(WebDriver driver, By locator, String page, String element, Logger log, ExtentTest test) throws ReusableComponentException {
        try {
            waitForElement(driver, locator, log, test).click();
            safePass(driver, test, "Clicked " + element + " in " + page, log);
        } catch (Exception e) {
            safeFail(driver, test, "Unable to click " + element + " in " + page, log);
            throw new ReusableComponentException("Unable to click " + element + " in " + page, e);
        }
    }

    public static void sendKeys(WebDriver driver, By locator, String page, String element, Logger log, ExtentTest test, String value) throws ReusableComponentException {
        try {
            WebElement ele = waitForElement(driver, locator, log, test);
            ele.clear();
            ele.sendKeys(value);
            safePass(driver, test, "Entered '" + value + "' into " + element + " in " + page, log);
        } catch (Exception e) {
            safeFail(driver, test, "Unable to send keys " + element + " in " + page, log);
            throw new ReusableComponentException("Unable to send keys " + element + " in " + page, e);
        }
    }

    private static void safePass(WebDriver driver, ExtentTest test, String msg, Logger log) {
        try { ExtentLogUtilities.pass(driver, test, msg, log); } catch (Exception e) { log.error("Fail pass log: "+msg); }
    }

    private static void safeFail(WebDriver driver, ExtentTest test, String msg, Logger log) {
        try { ExtentLogUtilities.fail(driver, test, msg, log); } catch (Exception e) { log.error("Fail fail log: "+msg); }
    }
}
