package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

        String host1 = "localhost";
        String host2 = "10.0.0.195";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host2 = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://" + host1 + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);
    }

    @AfterTest
    public void cleanUp(){
        System.out.println("Let's clean up and call it");
        this.driver.manage().deleteAllCookies();
        this.driver.quit();
    }
}
