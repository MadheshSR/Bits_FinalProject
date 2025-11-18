package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class BusBookUI {
	
	public By closeButton = By.xpath("//span[@role='presentation']");
    public By Bus = By.xpath("//span[normalize-space()='Bus']");
    public By from = By.xpath("//input[@id='autosuggestBusSRPSrcHome']");
    public By to = By.xpath("//input[@id='autosuggestBusSRPDestHome']");
    public By frm = By.xpath("//input[@type='text']");
    public By frmst = By.xpath("//span[normalize-space()='Chennai, Tamil Nadu']");

    public By toField = By.xpath("//input[@type='text']");
    public By tost = By.xpath("//span[normalize-space()='Bangalore, Karnataka']");

    public By datee = By.xpath("//p[normalize-space()='Departure']");
    public By srchtr = By.xpath("//button[normalize-space()='Search Bus']");



}
