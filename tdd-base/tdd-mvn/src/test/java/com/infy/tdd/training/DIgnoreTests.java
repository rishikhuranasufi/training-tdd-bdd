package com.infy.tdd.training;

import com.infy.tdd.training.core.TestCaseBase;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by EQS on 8/8/2018.
 * PURPOSE - Usage of Ignore annotation
 */

//@Ignore
//We can Ignore whole class use @Ignore annotation
public class DIgnoreTests extends TestCaseBase{

    //Different ways to Ignore a test cases
    //Just add a @Ignore annotation before or after the @Test method.
    @Ignore
    @Test
    public void testMath2() {
        assertThat(1 + 2, is(5));
    }

    @Ignore("some one please create a test for Math3!")
    @Test
    public void testMath3() {
        //...
    }
}
