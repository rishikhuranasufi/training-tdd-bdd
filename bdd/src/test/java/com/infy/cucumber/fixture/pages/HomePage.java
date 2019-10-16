package com.infy.cucumber.fixture.pages;

import com.infy.cucumber.core.WebDriverPageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by EQS on 9/5/2018.
 */
public class HomePage extends WebDriverPageObject {

    @FindBy(css = ".icon.icon-chevron-down")
    WebElement menu;

    //@FindBy(xpath = "//*[@id=\"page\"]/header/div/div/div/div/div/div[2]/ul/li[5]/a")
    @FindBy(css = ".icon.icon-logout")
    WebElement logOutButton;

    @FindBy(css = ".user-profile")
    WebElement userProfile;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logOut() throws InterruptedException {
        waitForPageToLoad();
        waitUntilVisible(menu);
        menu.click();
        logOutButton.click();
    }

    public void verifyLoggedInUserName(String username) throws InterruptedException {
        waitForPageToLoad();
        waitUntilVisible(userProfile);
        String usersProfile = userProfile.getText();
        Assert.assertNotNull(usersProfile);
        Assert.assertTrue(usersProfile.contains(username));
    }

    public void verify() {
        waitForPageToLoad();
        waitUntilVisible(menu);
        Assert.assertEquals("TimesPoints - Times Network Reward Program",driver.getTitle());
    }
}
