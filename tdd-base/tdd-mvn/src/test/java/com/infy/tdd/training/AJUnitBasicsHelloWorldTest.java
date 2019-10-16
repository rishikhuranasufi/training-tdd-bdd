package com.infy.tdd.training;

import com.infy.tdd.training.core.TestCaseBase;
import org.apache.log4j.Logger;
import org.junit.*;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by EQS on 8/2/2018.
 * PURPOSE - TO learn Basic annotations
 */
public class AJUnitBasicsHelloWorldTest extends TestCaseBase {

    /**
     * In this Test class we will learn basic annotations to be used in JUnit.
     @BeforeClass – Run once before any of the test methods in the class, public static void
     @AfterClass – Run once after all the tests in the class have been run, public static void
     @Before – Run before @Test, public void
     @After – Run after @Test, public void
     @Test – This is the test method to run, public void
     *
     * **/

    final static Logger logger = Logger.getLogger(AJUnitBasicsHelloWorldTest.class);
    JUnitBasicsHelloWorld jUnitBasicsHelloWorld = new JUnitBasicsHelloWorld();;

    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void before(){
        logger.debug("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        logger.debug("@AfterClass - runOnceAfterClass");
    }

    // Run it after test case
    @After
    public void runAfterTestMethod() {
        logger.debug("@After - runAfterTestMethod");
    }

    // Run it before test case
    @Before
    public void runBeforeTestMethod() {
        logger.debug("@Before - runBeforeTestMethod");
    }

    // Test case to execute
    @Test
    public void shouldSayHelloToTheWorld() {
        String helloMsg = jUnitBasicsHelloWorld.sayHello();
        logger.debug(helloMsg);
        assertThat(helloMsg, equalTo("Hello Students!!"));
    }

    @Test
    public void test_method_1() {
        logger.debug("@Test - test_method_1");
    }


    // To ignore test case @Ignore
    @Ignore
    public void test_method_2() {
        logger.debug("@Ignore - test_method_2");
    }
}