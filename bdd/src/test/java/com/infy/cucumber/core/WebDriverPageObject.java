package com.infy.cucumber.core;
import cucumber.api.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverPageObject {
    int timeOutInSeconds = 200;
    protected WebDriver driver;
    WebElement driverElement;
    protected WebDriverWait defaultWait;
    protected WebDriverWait loginWait;

    @FindBy(css = ".btn-link.bw-nav-link.bw-nav-pill.bw-nav-dropdown-menu-user-header.dropdown-toggle")
    protected WebElement profileLink;

    public WebDriverPageObject(WebDriver driver) {
        this.driver = driver;
        this.defaultWait = new WebDriverWait(driver, timeOutInSeconds);
        this.loginWait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void changePageWith(Runnable runnable) {
        String originalUrl = driver.getCurrentUrl();
        System.out.println(originalUrl);
        runnable.run();
        waitUntilUrlChanges(originalUrl);
    }


    public void openPortalNavigationMenu() {
        WebElement portalNavigationLink = driver.findElement(By.cssSelector(".bannerAreaButtons img"));
        portalNavigationLink.click();
    }

    public void clickLogout(){
        WebElement logoutLink = driver.findElement(By.cssSelector("ul.logoutDropDownUl .logoutText"));
        logoutLink.click();
    }

    public void openProfileMenu() {
        this.waitUntilVisible(this.profileLink);
        waitUntilEnabled(this.profileLink,true);
        this.profileLink.click();
    }

    public void waitUntilUrlChanges(final String originalUrl) {
        loginWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    return !originalUrl.equals(d.getCurrentUrl());
                } catch (Exception e) {
                    return Boolean.FALSE;
                }
            }

            @Override
            public String toString() {
                return "Url changes from: " + originalUrl;
            }
        });
    }

    public void setTextAndUnfocus(WebElement webElement, String text) {
        webElement = setText(webElement, text);
        webElement.sendKeys(Keys.TAB);
    }

    public WebElement setText(WebElement webElement, String text) {
        waitUntilVisible(webElement);
        webElement.clear();
        webElement.sendKeys(text);
        return webElement;
    }

    public WebElement clickOnElement(WebElement webElement) {
        waitUntilVisible(webElement);
        webElement.click();
        return webElement;
    }

    public WebElement waitUntilVisible(final WebElement element) {
        return waitUntilVisible(element, defaultWait);
    }

    public WebElement waitUntilVisible(final WebElement element, WebDriverWait theWait) {
        return theWait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return displayedElementOrNull(element);
            }

            @Override
            public String toString() {
                return "Should be visible: " + element;
            }
        });
    }

    public Boolean waitUntilEnabled(final WebElement element, final Boolean enabled) {
        return defaultWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return element.isEnabled() == enabled;
            }

            @Override
            public String toString() { return "Should be enabled " + enabled + ": " + element; }
        });
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void loadPage(String url)
    {

        //getCurrentDriver().get(url);
        driver.get(url);
    }
    public void switchToFrame(String frameName) {
        defaultWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    private WebElement displayedElementOrNull(WebElement element) {
        return element.isDisplayed() ? element : null;
    }



    /*public WebElement setTextNoAjaxWait(WebElement webElement, String text) {
        this.waitUntilVisible(webElement);
        int tries = 20;

        while(tries-- > 0) {
            webElement.clear();
            webElement.sendKeys(text);
            if(text.startsWith(webElement.getAttribute("value"))) {
                return webElement;
            }

            return loginWait;
        }

        throw new RuntimeException("Could not set text " + text + " to webelement");
    }*/
}