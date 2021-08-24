package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String numOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numOfPassengers", "expectedPrice"})
    public void setupParameter(String numOfPassengers, String expectedPrice){
        this.numOfPassengers = numOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium" , "docker");
        registrationPage.enterUserCredetials("selenium", "docker", "docker");
        registrationPage.clickSubmitBtn();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.clickFlightsLink();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(numOfPassengers);
        flightDetailsPage.arrivingIn("London");
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void goToBillingPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.goToBillingPage();
    }

    @Test(dependsOnMethods = "goToBillingPage")
    public void billingPage(){
        BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
        billingAddressPage.enterStreetAdr("Docker Street");
        billingAddressPage.enterCityInput("New Docker");
        billingAddressPage.enterStateInput("Selenoide");
        billingAddressPage.enterZipInput("99999");
        billingAddressPage.goToConfirmationPage();
    }

    @Test(dependsOnMethods = "billingPage")
    public void flightConfirmationValidation() throws InterruptedException {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

}
