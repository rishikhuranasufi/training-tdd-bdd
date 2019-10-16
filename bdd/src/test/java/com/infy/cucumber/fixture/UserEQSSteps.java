package com.infy.cucumber.fixture;

import com.infy.cucumber.core.Configuration;
import com.infy.cucumber.core.SeleniumDriverSuperPower;
import com.infy.cucumber.fixture.pages.EQSTrainingApp;
import com.infy.cucumber.fixture.continent.TeamContinent;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class UserEQSSteps {

    private World world;
    public UserEQSSteps(World world){
        this.world = world;
    }

    WebDriver driver;
    @When("^User navigates to EQS Portal for new team registration$")
    public void user_navigates_to_EQS_Portal_for_new_team_registration(){
       driver = SeleniumDriverSuperPower.setUpDriver();
       driver.get(Configuration.getConfig("portal.url"));
       EQSTrainingApp eqsTrainingApp = new EQSTrainingApp(driver);
       world.registerTeamPage = eqsTrainingApp.clickRegisterAndAgree();
    }

    @And("^enter following details for team (\\w+) registration:$")
    public void enter_following_details_for_team_registration(String qualifier, DataTable dataTable){
        List<List<String>> registrationData = dataTable.raw();
        TeamContinent.TeamId teamId =  world.teamContinent.getOrGenerate(qualifier,"password");
        world.registerTeamPage.setTeamUserNameAndPassowrd(teamId.getTeamName(), teamId.getTeamPassword());
        world.registerTeamPage.fillDataAndRegisterTeam(registrationData);
    }
}
