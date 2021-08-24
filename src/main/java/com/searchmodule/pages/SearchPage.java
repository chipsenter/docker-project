package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search_form_input_homepage")
    private WebElement search_input;

    @FindBy(id = "search_button_homepage")
    private WebElement search_btn;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://duckduckgo.com");
    }

    public void enterText(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(this.search_input));
        this.search_input.sendKeys(keyword);
        this.search_btn.click();
    }

    public void goToVideos() {
        wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getResult() {
        By by = By.className("tile--vid");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        System.out.println(this.allVideos.size());

        return this.allVideos.size();
    }


}
