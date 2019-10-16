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

@Category({PerformanceTests.class, RegressionTests.class})
public class ClassB extends TestCaseBase {
    static final Logger logger = Logger.getLogger(ClassB.class);

    @Test
    public void test_b_1() {
        logger.debug("I am PerformanceTests and RegressionTests Test case ");
        assertThat(1 == 1, is(true));
    }

}
