package com.infy.tdd.training.categories;

/**
 * Created by EQS on 8/2/2018.
 */
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(PerformanceTests.class)
//@Categories.IncludeCategory(RegressionTests.class)
//Include multiple categories
//@Categories.IncludeCategory({PerformanceTests.class, RegressionTests.class})
//@Categories.ExcludeCategory(PerformanceTests.class)
@Suite.SuiteClasses({ClassA.class, ClassB.class, ClassC.class})
public class RunningTestSuitesWithCategories {
}