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

public class ClassA extends TestCaseBase {
    static final Logger logger = Logger.getLogger(ClassA.class);

    @Category(PerformanceTests.class)
    @Test
    public void test_a_1() {
        logger.debug("I am PerformanceTest ");
        assertThat(1 == 1, is(true));
    }

    @Test
    public void test_a_2() {
        logger.debug("I am normal Test Case ");
        assertThat(1 == 1, is(true));
    }

}