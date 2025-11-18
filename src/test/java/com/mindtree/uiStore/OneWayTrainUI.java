package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class OneWayTrainUI {
	
	
    public By closeButton = By.xpath("//span[@role='presentation']");
    public By train = By.xpath("//span[normalize-space()='Trains']");
    public By from = By.xpath("//p[normalize-space()='Enter Source Name']");
    public By to = By.xpath("//p[normalize-space()='Enter Destination Name']");
    public By frm = By.xpath("//input[@type='text']");
    public By frmst = By.xpath("//span[normalize-space()='Chennai Central Railway Station']");

    public By toField = By.xpath("//input[@type='text']");
    public By tost = By.xpath("//span[normalize-space()='Bangalore City Junction']");

    public By datee = By.xpath("//p[normalize-space()='Departure']");
    public By dat = By.xpath("//div[h2[contains(text(),'November 2025')]]//p[normalize-space()='29']");
    public By body = By.tagName("body");
    public By tdy = By.xpath("//span[normalize-space()='Today']");

    public By srchtr = By.xpath("//span[normalize-space()='SEARCH TRAINS']");


}
