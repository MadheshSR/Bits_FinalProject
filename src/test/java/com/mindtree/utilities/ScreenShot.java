package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
    WebDriver driver;
    String path;

    public ScreenShot(WebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
    }

    public String saveScreenShots() throws IOException {
        TakesScreenshot shot = (TakesScreenshot) driver;
        File srcFile = shot.getScreenshotAs(OutputType.FILE);
        String fullPath = path + System.currentTimeMillis() + ".png";
        File destFile = new File(fullPath);
        FileUtils.copyFile(srcFile, destFile);
        return fullPath;
    }
}
