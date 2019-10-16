package com.infy.cucumber.fixture;

import cucumber.api.java.en.Then;

/**
 * Created by EQS on 9/6/2018.
 */
public class HomeSteps{

    private World world;

    public HomeSteps(World world){
        this.world = world;
    }

    @Then("^Home page should be displayed.$")
    public void verify_user_login_Is_Success_or_not() throws Throwable {
        world.homePage.verify();
    }

}
