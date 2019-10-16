package com.infy.cucumber.fixture;

import com.infy.cucumber.core.SeleniumDriverSuperPower;
import com.infy.cucumber.fixture.pages.EQSTrainingApp;
import com.infy.cucumber.fixture.pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by EQS on 9/6/2018.
 */
public class LoginSteps{

    private World world;

    public LoginSteps(World world){
        this.world = world;
    }

    public static final String APP_URL = "https://jsso.indiatimes.com/sso/identity/login?channel=timespoints&ru=http%3A%2F%2Fwww.timespoints.com%2F%23%2Flogin";
    WebDriver driver;
    @When("^User navigates to application and login with username \"(.*)\" and password \"(.*)\"$")
    public void user_login_to_timespoints(String username, String password) throws Throwable {
        driver = SeleniumDriverSuperPower.setUpDriver();
        driver.get(APP_URL);
        world.loginPage = new LoginPage(driver);
        world.homePage = world.loginPage.login(username,password);
    }

    @When("^User navigates to timespoints.com's login page$")
    public void user_navigates_to_timespoints(DataTable dataTable) throws Throwable {
        driver = SeleniumDriverSuperPower.setUpDriver();
        List<List<String>> data = dataTable.raw();
        driver.get(data.get(1).get(0));
        world.loginPage = new LoginPage(driver);
        //homePage = loginPage.login(data.get(1).get(0),data.get(1).get(1));

        //throw new PendingException();
    }

    @When("^User logs in using Username as$")
    public void userLoggedInAsUserName(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        world.loginPage.enterUserName(data.get(1).get(0));
    }

    @And("^User logs in with Password as$")
    public void userLoggedInAsPassword(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        world.homePage = world.loginPage.enterPassword(data.get(1).get(0));
    }


    @Then("^Login should be successful as$")
    public void userShouldLoginSuccess(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        world.homePage.verifyLoggedInUserName(data.get(1).get(0));
    }


    @Then("^Home page should be displayed$")
    public void verify_user_login_Is_Success_or_not() throws Throwable {
        world.homePage.verify();
    }

    @Then("^Log out from the application$")
    public void log_out_from_the_application() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.homePage.logOut();
        //Braina
    }
    @When("^User navigates to EQS training app login page$")
    public void user_navigates_to_EQSTrainingApp(DataTable dataTable) throws Throwable {
        driver = SeleniumDriverSuperPower.setUpDriver();
        List<List<String>> data = dataTable.raw();
        driver.get(data.get(1).get(0));
        world.eqsTrainingApp = new EQSTrainingApp(driver);
    }

    @When("^User sign in using Username as$")
    public void userLoggedInAsUserNameEQSAPP(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        world.eqsTrainingApp.enterUserName(data.get(1).get(0));
    }

    @And("^User sign in with Password as$")
    public void userLoggedInAsPasswordEQSApp(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        world.homePageEQS = world.eqsTrainingApp.enterPasswordAndClick(data.get(1).get(0));
    }
    @Then("^EQS App Login should be successful as$")
    public void userShouldLoginSuccessEQSAPP(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        world.homePageEQS.verifyLoggedInUserName(data.get(1).get(0));
    }

    @Then("^EQS App Log out from the application$")
    public void log_out_from_the_EQS_application() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        world.homePageEQS.logOut();
        //Braina
    }
}
