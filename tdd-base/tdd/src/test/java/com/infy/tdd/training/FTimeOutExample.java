package com.infy.tdd.training;

import com.infy.tdd.training.core.TestCaseBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by EQS on 8/8/2018.
 * PURPOSE - Understand TIMEOUT and how it should be used
 */
public class FTimeOutExample extends TestCaseBase{

    //This test will always failed :)
    @Test(timeout = 1000)
    public void infinity() {
        //Uncomment this line to show Example
        //while (true) ;
    }

    //This test can't run more than 5 seconds, else failed
    @Test(timeout = 5000)
    public void testSlowMethod() {
        //...
    }

    //global timeout rule
    //Note All unit test should be fast, and this global timeout rule should be your best helper.
    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    //This test will be failed, because it will take more than 1 second to finish!
    @Test
    public void testSlowMethod1() throws InterruptedException {
        //...
        ////Uncomment this line to show Example
        //TimeUnit.SECONDS.sleep(5000);
    }

    //passed
    @Test
    public void testSlowMethod2() {
        //...
    }
}
