package com.infy.cucumber.fixture.pages;

import com.infy.cucumber.core.WebDriverPageObject;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by EQS on 9/5/2018.
 *
 */
public class LoginPage extends WebDriverPageObject {

    @FindBy(xpath="//*[@id=\"emailId\"]")
    WebElement user;

    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement pass;

    @FindBy(xpath="//*[@id=\"signInButtonDiv\"]/input")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //WebDriverPageObject browserDriver;
    public HomePage login(String userName, String password) throws InterruptedException {
        //loadPage(loginDetails.get(0).getUrl());
        setTextAndUnfocus(user, userName);
        setTextAndUnfocus(pass, password);
        //loginBtn.click();
        //Thread.sleep(10000);
        //clickOnElement();
        return new HomePage(driver);
    }

    public void enterUserName(String userName) throws InterruptedException {
        //Set User Name and unfocus it to move on to new Text box
        setTextAndUnfocus(user, userName);
    }

    public HomePage enterPassword(String password) throws InterruptedException {
        //Set Password and unfocus it to move on to login
        setTextAndUnfocus(pass, password);
        return new HomePage(driver);
    }
}
