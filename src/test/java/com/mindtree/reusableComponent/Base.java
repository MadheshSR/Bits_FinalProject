package com.mindtree.reusableComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    private static WebDriver driver;
    public static ExtentReports report;

    // Load properties from file
    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize ExtentReports
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + timestamp + ".html";
        report = new ExtentReports(reportPath, true);
    }
        //report = new ExtentReports(System.getProperty("user.dir") + "/Reports/ExtentReport.html", true);
    

    // Get WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            // Automatically downloads correct ChromeDriver version
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }


    // Quit driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Get property from config
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
