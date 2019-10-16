package com.infy.tdd.training;

import com.infy.tdd.training.categories.ClassA;
import com.infy.tdd.training.categories.ClassB;
import com.infy.tdd.training.categories.ClassC;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by EQS on 8/2/2018.
 * PURPOSE - Means to include all set of jUNIT Test classes
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AJUnitBasicsHelloWorldTest.class, //test case 1
        BCalculatorExampleTest.class,     //test case 2
        EListTest.class,
        ClassA.class,
        ClassB.class,
        ClassC.class,
        DIgnoreTests.class
})
public class GSuiteTest {


}
