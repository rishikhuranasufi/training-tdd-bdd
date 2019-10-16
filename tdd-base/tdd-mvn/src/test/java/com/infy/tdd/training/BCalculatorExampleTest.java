package com.infy.tdd.training;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import com.infy.tdd.training.core.TestCaseBase;
import org.apache.log4j.Logger;
import org.junit.Test;

public class BCalculatorExampleTest extends TestCaseBase{

	/* Created by EQS on 8/8
	PURPOSE - Basic examples to run and look at coverage
	 */

	CalculatorExample calculatorExample = new CalculatorExample();
	final static Logger logger = Logger.getLogger(BCalculatorExampleTest.class);

    @Test
	public void shouldAddTwoNumbers(){
		int sumIs= calculatorExample.additionOfNumbers(10,10);
		logger.debug(sumIs);
		assertNotNull(sumIs);
        assertEquals(sumIs,20);
        // Show example of HRunSuiteAndPrintResults
        //assertEquals(sumIs,21);
    }

	@Test
	public void shouldMultipleTwoNumbers(){
		int mulOutputIs= calculatorExample.multiplicationOfNumbers(10,10);
		logger.debug(mulOutputIs);
		assertEquals(mulOutputIs,100);
        // Show example of HRunSuiteAndPrintResults
        //assertEquals(mulOutputIs,101);
	}

	@Test
	public void testSubtractNumbers() throws Exception {
		int output = calculatorExample.subtractNumbers(30,20);
		assertNotNull(output);
		logger.debug(output);
		//TO Show case
		//assertEquals(output,11);
		assertEquals(output,10);
		// Show example of HRunSuiteAndPrintResults
        //assertEquals(output,11);

	}
}
