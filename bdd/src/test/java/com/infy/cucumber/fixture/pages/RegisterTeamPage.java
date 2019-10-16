package com.infy.cucumber.fixture.pages;

import com.infy.cucumber.core.WebDriverPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by karanbir.saluja on 22/5/2018.
 */
public class RegisterTeamPage extends WebDriverPageObject {

    @FindBy(id = "login-username")
    WebElement teamName;

    @FindBy(id = "services")
    WebElement services;

    @FindBy(id = "team-lead-name")
    WebElement teamLeadName;

    @FindBy(id = "gm-name")
    WebElement gmName;

    @FindBy(id = "organisation")
    WebElement organisation;

    @FindBy(id = "location")
    WebElement location;

    @FindBy(id = "requester-name")
    WebElement requesterName;

    @FindBy(name = "requesterMailId")
    WebElement requesterMailId;

    @FindBy(name = "security-answer")
    WebElement securityAnswer;

    @FindBy(name = "gmMailId")
    WebElement gmMailId;

    @FindBy(id = "teamPassword")
    WebElement teamPassword;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement nextbutton;

    public RegisterTeamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setTeamUserNameAndPassowrd(String userName, String password) {
        setTextAndUnfocus(teamName, userName);
        setTextAndUnfocus(teamPassword, password);
    }

    public void fillDataAndRegisterTeam(List<List<String>> registrationData) {
        setTextAndUnfocus(services, registrationData.get(0).get(1));
        setTextAndUnfocus(teamLeadName, registrationData.get(1).get(1));
        setTextAndUnfocus(gmName, registrationData.get(2).get(1));
        setTextAndUnfocus(organisation, registrationData.get(3).get(1));
        setTextAndUnfocus(location, registrationData.get(4).get(1));
        setTextAndUnfocus(requesterName, registrationData.get(5).get(1));
        setTextAndUnfocus(requesterMailId, registrationData.get(6).get(1));
        setTextAndUnfocus(securityAnswer, registrationData.get(7).get(1));
        setTextAndUnfocus(gmMailId, registrationData.get(8).get(1));

    }
}
