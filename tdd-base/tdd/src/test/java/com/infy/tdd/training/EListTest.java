package com.infy.tdd.training;

/*
 * Created by EQS on 8/2/2018.
 * PURPOSE - How to Handle lists & Arraylists
 */
import com.infy.tdd.training.core.TestCaseBase;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

public class EListTest extends TestCaseBase{

    CalculatorExample calculatorExample = new CalculatorExample();
    final static Logger logger = Logger.getLogger(EListTest.class);


    @Test
    public void testAssertList() {

        List<String> actual = Arrays.asList("a", "b", "c");
        //List<String> expected = Arrays.asList("a", "b", "c");
        List<String> expected = calculatorExample.getArrayList("a","b","c");
        logger.debug("Running List tests");


        //All passed / true

        //1. Test equal.
        assertThat(expected, is(expected));

        //2. If List has this value?
        assertThat(expected, hasItems("b"));

        //3. Check List Size
        assertThat(expected, hasSize(3));

        assertThat(expected.size(), is(3));

        //4.  List order

        // Ensure Correct order
        assertThat(actual, contains("a", "b", "c"));

        // Can be any order
        assertThat(actual, containsInAnyOrder("c", "b", "a"));

        //5. check empty list
        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

    }


    //Playing with List of an Object
    @Test
    public void testAssertListAsAnObject() {

        List<Fruit> list = Arrays.asList(
                new Fruit("Banana", 99),
                new Fruit("Apple", 20)
        );

        //Test equals
        assertThat(list, hasItems(
                new Fruit("Banana", 99),
                new Fruit("Apple", 20)
        ));

        assertThat(list, containsInAnyOrder(
                new Fruit("Apple", 20),
                new Fruit("Banana", 99)
        ));

        //Test class property, and its value
        assertThat(list, containsInAnyOrder(
                hasProperty("name", is("Apple")),
                hasProperty("name", is("Banana"))
        ));

    }

}
