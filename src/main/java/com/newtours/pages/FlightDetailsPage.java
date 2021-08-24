package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    private WebElement passengers;

    @FindBy(id = "findFlights")
    private WebElement continue_btn;

    @FindBy(id = "reserveFlights")
    private WebElement reserve_flights;

    @FindBy(name = "toPort")
    private WebElement fly_to;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String numOfPassengers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.passengers));
        Select select = new Select(passengers);
        select.selectByValue(numOfPassengers);
    }

    public void arrivingIn(String country) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.fly_to));
        Select select = new Select(fly_to);
        select.selectByValue(country);
    }

    public void goToFindFlightsPage(){
        this.continue_btn.click();
    }

    public void goToBillingPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.reserve_flights));
        this.reserve_flights.click();
    }


}
