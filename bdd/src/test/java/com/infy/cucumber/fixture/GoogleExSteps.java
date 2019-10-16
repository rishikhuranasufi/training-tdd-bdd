package com.infy.cucumber.fixture;

import com.infy.cucumber.core.Configuration;
import com.infy.cucumber.core.SeleniumDriverSuperPower;
import com.infy.cucumber.fixture.pages.GooglePage;
import cucumber.api.Scenario;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by EQS - Msg 1 - no webElement should be covered in Stepdef files
 * Msg 2 - under pages, please refer to Pages - GooglePage for webelement definition & usage
 */
public class GoogleExSteps {
    private World world;

    public GoogleExSteps(World world){
        this.world = world;
    }

//    public static final String GOOGLE_URL = "https://www.google.co.in/";
    WebDriver driver;

    @When("^a web browser is at the Google home page$")
    public void openGoogleWebpage(){
        driver = SeleniumDriverSuperPower.setUpDriver();
        driver.get(Configuration.getConfig("google.url"));
        world.googlePage = new GooglePage(driver);
    }

    @When("^User Enter ([^\"]*) to google search$")
    public void enter(String textToSearch){
        world.googlePage.enterSearchText(textToSearch);
    }

    @When("^User clicks \"(.*)\"$")
    public void clickOnButton(String buttonType){
        world.googlePage.clickOnButton(buttonType);
    }

    @When("^Details related to ([^\"]*) are shown on the next page$")
    public void checkOutput(String srcText){
        world.googlePage.verifyPageDetails();
    }
}
