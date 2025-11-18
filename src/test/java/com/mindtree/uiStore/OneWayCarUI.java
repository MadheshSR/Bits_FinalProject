package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class OneWayCarUI {
	
	
    public By closeButton = By.xpath("//span[@role='presentation']");
    public By cabs = By.xpath("//span[normalize-space()='Cabs']");
    public By HouRen = By.xpath("//span[normalize-space()='Hourly Rental']");
    public By from = By.xpath("//input[@id='downshift-1-input']");
   // public By to = By.id("toCity");

    public By frm = By.xpath("//input[@placeholder='From']");
    public By datee = By.xpath("//label[normalize-space()='Pickup Date']");
    public By dat = By.xpath("//span[normalize-space()='29']");

    public By km = By.xpath("//span[normalize-space()='3 hr']");
    public By srchcb = By.xpath("//button[normalize-space()='SEARCH CABS']");



}
