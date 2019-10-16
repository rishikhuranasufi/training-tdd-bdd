package com.infy.cucumber.fixture;

import com.infy.cucumber.fixture.continent.TeamContinent;
import com.infy.cucumber.fixture.pages.*;

/**
 * Created by EQS on 9/10/2018.
 */
public class World {
    HomePage homePage;
    LoginPage loginPage;
    GooglePage googlePage;
    HomePageEQS homePageEQS;

    // Pages for EQS Portal
    EQSTrainingApp eqsTrainingApp;
    RegisterTeamPage registerTeamPage;

    TeamContinent teamContinent = new TeamContinent();

}
