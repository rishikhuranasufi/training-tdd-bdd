package com.infy.cucumber.core;

import org.openqa.selenium.WebDriver;

/**
 * Created by EQS on 9/5/2018.
 */
public class SeleniumDriverSuperPower {

    synchronized public static WebDriver setUpDriver(){
        return BrowserDriver.initBrowser();
    }
}
