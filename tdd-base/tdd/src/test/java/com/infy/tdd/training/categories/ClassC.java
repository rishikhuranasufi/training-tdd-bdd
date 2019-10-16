package com.infy.tdd.training.categories;

/**
 * Created by EQS on 8/2/2018.
 */
import com.infy.tdd.training.core.TestCaseBase;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClassC extends TestCaseBase{
    static final Logger logger = Logger.getLogger(ClassC.class);


    @Category({PerformanceTests.class, RegressionTests.class})
    @Test
    public void test_c_1() {
        logger.debug("I am PerformanceTest and Regression test case");
        assertThat(1 == 1, is(true));
    }

    @Category(RegressionTests.class)
    @Test
    public void test_c_2() {
        logger.debug("I am RegressionTest ");
        assertThat(1 == 1, is(true));
    }

}
