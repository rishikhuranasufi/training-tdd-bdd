package com.infy.cucumber.fixture.pages;

import com.infy.cucumber.core.WebDriverPageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by EQS on 9/10/2018.
 */
public class GooglePage extends WebDriverPageObject {

//    @FindBy(name = "btnK")
    @FindBy(xpath = "//input[@name='btnK']")
    WebElement googleSearch;

    @FindBy(name = "btnI")
    WebElement feelingLucky;

//    @FindBy(xpath = "//*[@id=\"lst-ib\"]")
    @FindBy(name = "q")
    WebElement searchTextBox;


    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);//PageFactory best practice to find an element
        //this avoids driver.findElement
    }

    public void enterSearchText(String textToSearch){
        setTextAndUnfocus(searchTextBox,textToSearch);
    }

    public void clickOnButton(String buttonType){
        if(buttonType.equals("Google Search")) {
            waitUntilEnabled(this.googleSearch, true);
            googleSearch.submit();
        }
        else
            feelingLucky.submit();
    }

    public void verifyPageDetails(){
        String title = driver.getTitle();
        Assert.assertNotEquals("Google",title);
    }
}
