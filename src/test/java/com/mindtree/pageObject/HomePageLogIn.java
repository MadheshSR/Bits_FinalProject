package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.HomePageLogInUi;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePageLogIn extends HomePageLogInUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public HomePageLogIn(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
		Thread.sleep(5000);

	}

	public void clickCloseButton() throws ReusableComponentException, Exception {
		WebDriverSupport.click(driver, closeButton, "Signup Box", "Close Button", log, test);
		Thread.sleep(5000);
	}

	public void validate() throws ReusableComponentException, Exception {
		if (driver.findElement(getHome).isDisplayed()) {
			WebDriverSupport.click(driver, getHome, "HomePage", "Goibibo", log, test);
		}
		WebDriverSupport.click(driver, getHome, "Goibibo page", "Logo", log, test);
		Thread.sleep(5000);
}
}
