package com.mindtree.stepDefinitions;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.HomePageLogIn;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePageLoginStepDef extends Base {

    private WebDriver driver;
    private HomePageLogIn hmlog;
    private Logger log = Logger.getLogger(HomePageLoginStepDef.class);
    private ExtentTest test;

    public HomePageLoginStepDef() throws UtilityException, Exception {
        super();
    }

    @Before("@HomePageLogin")
    public void setUp() throws Exception {
        driver = getDriver(); // Reuse same driver
        test = report.startTest("Home Page Login Test");
        hmlog = new HomePageLogIn(driver, log, test);
    }

    @Given("URl opened with URL for login")
    public void openLoginPage() throws Exception {
        String url = GetProperties.getProperty("url");
        driver.get(url);
        ExtentLogUtilities.pass(driver, test, "URL opened: " + url, log);
    }

    @Then("Clicked one Signup window close")
    public void closeSignupWindow() throws ReusableComponentException, Exception {
        hmlog.clickCloseButton();
    }

    @Then("user will direct to home page")
    public void validateHomePage() throws ReusableComponentException, Exception {
        hmlog.validate();
    }

    @After("@HomePageLogin")
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
