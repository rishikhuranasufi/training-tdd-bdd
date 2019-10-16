package com.infy.tdd.training;

import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

/**
 * Created by EQS on 8/2/2018.
 * PURPOSE - Run all classes from here and log details
 */
public class HRunSuiteAndPrintResults {

    final static Logger logger = Logger.getLogger(GSuiteTest.class);

    public static void main(String arg[]){
        Result result = JUnitCore.runClasses(GSuiteTest.class);
        List<Failure> failedTestCases = result.getFailures();
        logger.debug("Test Cases details:");
        logger.debug("Total test cases count are "+ result.getRunCount());
        logger.debug("Total test cases Ignored are  "+ result.getIgnoreCount());
        logger.debug("Failed test cases count is "+failedTestCases.size());
        //TODO Print passed test cases count.
        //Show an example where we will fail the test cases if ignore count is more than 1
        if(failedTestCases.size()>0){
            logger.debug("Failed test cases count is "+failedTestCases.size()+" Please find below details");
            failedTestCases.stream().forEach(logger::debug);
            //failedTestCases.stream().forEach(failure -> logger.debug(failure));
        }

        int ignoreCount = 10;
        //int ignoreCount = 1;
        if (result.getIgnoreCount()>=ignoreCount){
            logger.error("Tests were ignored Please run all the tests ");
            //Send a Failure email or perform any required action !!
            System.exit(1);
        }
        if (result.getRunCount() >=1 && result.getFailureCount()>=0 ){
            logger.debug("TEST Cases executed SUCCESSFULLY !! Cheers ");
            //Send an Success email or perfome any required action !!
        }
    }
}
