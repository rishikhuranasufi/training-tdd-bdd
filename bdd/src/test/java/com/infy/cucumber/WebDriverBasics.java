package com.infy.cucumber;

/**
 * Created by EQS on 9/10/2018.
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverBasics {

    public static final String URL_TOOPEN = "http://www.calculator.net/";

    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //System.setProperty("webdriver.ie.driver", "C://chromedriver_win32//IEDriverServer.exe");
        //Chrome
        WebDriver driver = new ChromeDriver(capabilities);

        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to(URL_TOOPEN);

        //Another way to open browser
        //driver.get(URL_TOOPEN);


        //Maximize the browser
        driver.manage().window().maximize();

        // Click on Math Calculators
        driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[3]/div[2]/a")).click();

        // Click on Percent Calculators
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("50");

        // Click Calculate Button
        driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();

        //Few other ways to find elements
        //By.name()
        //By.cssSelector()
        //By.tagName()
        // Get the Result Text based on its xpath
        String result =
                driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();

        Thread.sleep(10000);
        // Print a Log In message to the screen
        System.out.println(" The Result is " + result);

        //Close the Browser.
        driver.close();
        driver.quit();
    }


}

