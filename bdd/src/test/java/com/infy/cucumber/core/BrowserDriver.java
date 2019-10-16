package com.infy.cucumber.core;


import cucumber.api.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class BrowserDriver {

    static enum Browser {
        FIREFOX, CHROME, IE;
    }
    static WebDriver driver =null;

    private static WebDriver localWebDriver(Browser browser) {
        try {
            DesiredCapabilities capability;
            WebDriver driver;
            switch (browser) {
                /*case Browser.PHANTOMJS:
                    ArrayList<String> cliArgsCap = new ArrayList<String>()
                    cliArgsCap.add("--ssl-protocol=any")
                    cliArgsCap.add("--ignore-ssl-errors=true")
                    capability = DesiredCapabilities.phantomjs()
                    capability.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap)
                    capability.setCapability("phantomjs.page.customHeaders.Accept-Language", "en-US")
                    capability.setJavascriptEnabled(true)
                    driver = new PhantomJSDriver(capability)
                    break*/
                case FIREFOX:
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setAcceptUntrustedCertificates(true);
                    profile.setAssumeUntrustedCertificateIssuer(false);
                    capability = DesiredCapabilities.firefox();
                    capability.setCapability(FirefoxDriver.PROFILE, profile);
                    capability.setCapability("overlappingCheckDisabled", true);
                    driver = new FirefoxDriver(capability);
                    break;
                case CHROME:
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    //System.setProperty("webdriver.ie.driver", "C://chromedriver_win32//IEDriverServer.exe");
                    //Chrome
                    driver = new ChromeDriver(capabilities);
                    //WebDriverManager.chromedriver().setup();
                    //driver = new ChromeDriver(capabilities);
                    //driver = new ChromeDriver();
                    break;
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            return driver;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver initBrowser() {
        //String browser = Configuration.getConfig("selenium.browser");
        driver = localWebDriver(Browser.CHROME);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriverObject(){
        return driver;
    }

    public static void saveScreenShot(WebDriver driver, File file) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        StreamUtils.copyFile(scrFile, file);
        scrFile.deleteOnExit();
    }

}