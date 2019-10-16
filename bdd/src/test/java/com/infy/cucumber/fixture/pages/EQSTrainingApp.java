package com.infy.cucumber.fixture.pages;

import com.infy.cucumber.core.WebDriverPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rishi.khurana on 11/9/2018.
 */
public class EQSTrainingApp extends WebDriverPageObject {


    @FindBy(xpath="//*[@id=\"username\"]")
    WebElement user;

    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement pass;

    @FindBy(xpath="//*[@id=\"light\"]/div/div[1]/div[2]/div[3]/button[1]")
    WebElement loginBtn;

    @FindBy(xpath = "//div[contains(text(),'Register')]")
    WebElement register;

    @FindBy(xpath = "//div[@class='col-md-2']//input[@type='radio']")
    WebElement agreeToRegister;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement nextbutton;

    public EQSTrainingApp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String userName) throws InterruptedException {
        //Set User Name and unfocus it to move on to new Text box
        setText(user, userName);
    }

    public HomePageEQS enterPasswordAndClick(String password) throws InterruptedException {
        //Set Password and unfocus it to move on to login
        setText(pass, password);
        clickOnElement(loginBtn);
        return new HomePageEQS(driver);
    }

    public RegisterTeamPage clickRegisterAndAgree(){
        clickOnElement(register);
        waitUntilVisible(agreeToRegister).click();
        nextbutton.click();
        return new RegisterTeamPage(driver);
    }
}
