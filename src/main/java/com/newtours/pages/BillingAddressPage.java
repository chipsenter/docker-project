package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "input_53_addr_line1")
    private WebElement street_adr_input;

    @FindBy(id = "input_53_city")
    private WebElement city_input;

    @FindBy(id = "input_53_state")
    private WebElement state_input;

    @FindBy(id = "input_53_postal")
    private WebElement zip_input;

    @FindBy(id = "buyFlights")
    private WebElement continue_btn;


    public BillingAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void enterStreetAdr(String adr) {
        this.wait.until(ExpectedConditions.visibilityOf(this.street_adr_input));
        this.street_adr_input.sendKeys(adr);
    }

    public void enterCityInput(String city) {
        this.city_input.sendKeys(city);
    }

    public void enterStateInput(String state) {
        this.state_input.sendKeys(state);
    }

    public void enterZipInput(String zip) {
        this.zip_input.sendKeys(zip);
    }

    public void goToConfirmationPage() {
        this.continue_btn.click();
    }
}
