package com.infy.tdd.training;

import com.infy.tdd.training.core.TestCaseBase;
import com.infy.tdd.training.exception.NameNotFoundException;
import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by EQS on 8/8/2018.
 */
public class CExceptionTests extends TestCaseBase{

    /*
	PURPOSE - Understanding how to manage Exceptions with jUnit */

    CalculatorExample calculatorExample = new CalculatorExample();
    final static Logger logger = Logger.getLogger(BCalculatorExampleTest.class);


    //Verifying wrong data will fail with exception ArithmeticException
    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        logger.debug("Start testDivisionWithException");
        int output = calculatorExample.divisionOfNumbers(1,0);
        //Control won't go till here because it will throw an Exception and
        // it is expected this test case must throw ArithmeticException
        logger.debug(output);
    }

    //Verifying wrong data will fail with exception ArithmeticException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyList() {
        logger.debug("Starting testEmptyList");
        ArrayList<String> arrayToCompute = calculatorExample.getArrayList(null);
        String output = arrayToCompute.get(0);
        //Control won't come after here because it will throw an Exception and
        // it is expected this test case must throw IndexOutOfBoundsException
        logger.debug(output);

    }


    //Try-catch and always fail()
    /**Always remember the fail()!
     * If the line you want to test didn’t throw any exception,
     * and you forgot to put the fail(), the test will be passed (false positive).
     **/
    @Test
    public void testDivisionWithExceptionWithTryCatchAndFail() {
        try {
            logger.debug("Start testDivisionWithExceptionWithTryCatchAndFail");
            int output = calculatorExample.divisionOfNumbers(1,0);
            // try below example to explain fail properly!
            //int output = calculatorExample.divisionOfNumbers(1,1);
            fail(); //remember this line, else 'may' false positive
            logger.debug(output);
        } catch (ArithmeticException e) {
            logger.debug("ERRROR"+ e.getMessage());
            assertThat(e.getMessage(), is("/ by zero"));
            //assert others
        }
    }

    //Try-catch and always fail()
    /**Always remember the fail()!
     * If the line you want to test didn’t throw any exception,
     * and you forgot to put the fail(), the test will be passed (false positive).
     **/

    @Test
    public void testEmptyListWithFail() {
        try {
            logger.debug("Starting testEmptyList");
            ArrayList<String> arrayToCompute = calculatorExample.getArrayList(null);

            //Try this example to explain fail()
            //ArrayList<String> arrayToCompute = calculatorExample.getArrayList("Rishi");
            String output = arrayToCompute.get(0);
            //Control won't come after here because it will throw an Exception and
            // it is expected this test case must throw IndexOutOfBoundsException
            logger.debug(output);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    /*
    * Most Elegant way:
    * @Rule ExpectedException
    * */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testDivisionWithExceptionWithRule() {

        thrown.expect(ArithmeticException.class);
        thrown.expectMessage(containsString("/ by zero"));

        int output = calculatorExample.divisionOfNumbers(1,0);
    }

    /*
    *@Rule Example two
     */

    @Test
    public void testNameNotFoundException() throws NameNotFoundException {

        //test type
        thrown.expect(NameNotFoundException.class);

        //test message
        thrown.expectMessage(is("Name is empty!"));

        //test detail
        thrown.expect(hasProperty("errCode"));  //make sure getters n setters are defined.
        thrown.expect(hasProperty("errCode", is(666)));

        CustomerService cust = new CustomerService();
        cust.findByName("");

    }
}
