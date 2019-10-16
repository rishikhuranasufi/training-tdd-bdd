package com.infy.cucumber.fixture;

import com.infy.cucumber.core.BrowserDriver;
import com.infy.cucumber.core.Configuration;
import com.infy.cucumber.core.SeleniumDriverSuperPower;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by rishi.khurana on 10/4/2018.
 */
public class Hooks {

    @After
    public void closeBrowser(Scenario scenario) {
        WebDriver driver = BrowserDriver.getDriverObject();
        try{
            //TODO implement logger!!
            if (scenario.isFailed()){
                try {
                    if (driver != null)
                    {
                        String screenShotDir = Configuration.getConfig("screenshot.directoryLocation");
                        String screenShotId = Long.toString(System.nanoTime());
                        String screenShotPath = Configuration.getConfig("screenshot.hostedLocation") + screenShotId;
                        BrowserDriver.saveScreenShot(driver, new File(screenShotDir + screenShotId +".png"));
                    }
                } catch (Exception ex) {
                }
            }

            System.out.println("Calling After hooks");
            driver.close();
            driver.quit();
        }catch (Exception ex){
            //Existing gracefully, browser already existed successfully !!
            //TODO implement logger!!
            System.err.println("Exception while closing browser");
        }


    }
}
