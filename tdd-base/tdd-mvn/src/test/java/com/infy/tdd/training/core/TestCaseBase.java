package com.infy.tdd.training.core;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Created by EQS on 8/2/2018.
 *
 * All the Functionality to be used across all the test cases must be specified in this class.
 * For example loading log4j.properties file
 */
public class TestCaseBase {

    //@Rule
    //public Timeout globalTimeout = new Timeout(1000);

    static {
        PropertyConfigurator.configure("log4j.properties");
    }
}
