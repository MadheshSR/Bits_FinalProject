package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class HotelSearchUI {
	
	
	public By closeButton = By.xpath("//span[@role='presentation']");
    public By Hotel = By.xpath("//span[normalize-space()='Hotels']");
    public By txt = By.xpath("//h2[normalize-space()='Book Hotels and Homestays']");

    public By from = By.xpath("//span[normalize-space()='Where to']");
    public By frm = By.xpath("//input[@type='text']");

    public By srch = By.xpath("//a[normalize-space()='SEARCH']");


}
