package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class OneWayFlightUI {

    // Signup popup
    public By closeButton = By.xpath("//span[@role='presentation']");

    // Flight From / To
    public By from = By.id("fromCity");
    public By to = By.id("toCity");
    public By frm = By.xpath("//input[@placeholder='From']");
    public By toField = By.xpath("//input[@placeholder='To']");

    // Date picker
    public By datee = By.xpath("//span[normalize-space()='Departure']");

    // Travellers
    public By trav = By.xpath("//label[@for='travellers']");
    public By done = By.xpath("//button[normalize-space()='APPLY']");

    // Search
    public By srch = By.xpath("//a[normalize-space()='Search']");
    public By cls = By.xpath("//span[@class='bgProperties overlayCrossIcon icon20']");
    public By student = By.xpath("//span[normalize-space()='Student']");
    public By indigo = By.xpath("(//p[contains(text(),'Non Stop')])[1]");
    public By tym = By.xpath("//div[@class='filtersOuter']//div//div[1]//div[1]//div[2]");
    public By fare = By.xpath("(//span[@data-test='component-buttonText'][normalize-space()='VIEW FARES'])[1]");
    public By booknow = By.xpath("(//button[@type='button'][normalize-space()='BOOK NOW'])[1]");
    public By rules = By.xpath("(//span[@data-test='component-cta'])[1]");
    public By datechange = By.xpath("(//a[normalize-space()='Date change charges'])[1]");
    public By close = By.xpath("(//span[@class='bgProperties overlayCrossIcon icon20'])[1]");
    public By addbaggage = By.xpath("(//font[normalize-space()='+ ADD BAGGAGE'])[1]");
    public By plus5 = By.xpath("(//span[@class='qtyActions'][normalize-space()='+'])[1]");
    public By done1 = By.xpath("(//button[normalize-space()='DONE'])[1]");
    public By bestvalue = By.xpath("(//div[@class='radioLabel'])[2]");
    public By viewbene = By.xpath("(//div[@class='viewAllPlan'])[1]");
    public By secure = By.xpath("//b[normalize-space()='Yes,']");
    public By contribute = By.xpath("(//span[@class='switchTrack makeFlex hrtlCenter'])[1]");

    //BookingDetails
    public By mob = By.xpath("(//input[@placeholder='Mobile No'])[1]");
    public By email = By.xpath("(//input[@placeholder='Email'])[1]");
    public By address = By.xpath("//input[@id='Billing Address']");
    public By pincode = By.xpath("//input[@id='Pincode']");
    public By contue = By.xpath("(//button[normalize-space()='Continue'])[1]");
    public By clso = By.xpath("//span[@class='multifareCross']");

    // Flight page close
    public By txt = By.xpath("//font[normalize-space()='Kindly add all travellers before proceeding']");
    public By getHome = By.xpath("//span[@class='sc-bQdRvg gKpxJG header-sprite logo gi-logo']");
}
