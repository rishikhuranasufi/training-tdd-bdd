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
public class HomePageEQS extends WebDriverPageObject {

    @FindBy(xpath = "//*[@id=\"home\"]/div/button")
    WebElement menu;

    //@FindBy(xpath = "//*[@id=\"page\"]/header/div/div/div/div/div/div[2]/ul/li[5]/a")
    @FindBy(xpath = "//*[@id=\"home\"]/div/div/a[2]")
    WebElement logOutButton;



    public HomePageEQS(WebDriver driver) {
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
        waitUntilVisible(menu);
        String usersProfile = menu.getText();
        if(usersProfile.equals(" Guest   ")){
            Thread.sleep(10000);
            usersProfile = menu.getText().trim();
        }
        Assert.assertNotNull(usersProfile);
        Assert.assertEquals(usersProfile,username);
        Assert.assertTrue(usersProfile.contains(username));
    }
}
