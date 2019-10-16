package com.infy.tdd.training.mock;

/**
 * Created by rishi.khurana on 2/3/2019.
 */
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class CMockitoInjectMockAnnotationExample {


    @Mock
    List<String> mockList;

    //@InjectMock creates an instance of the class and
    //injects the mocks that are marked with the annotations @Mock into it.
    @InjectMocks
    Fruits mockFruits;

    @Before
    public void setup() {
        //if we don't call below, we will get NullPointerException
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        when(mockList.get(0)).thenReturn("Apple");
        when(mockList.size()).thenReturn(1);
        Assert.assertEquals("Apple", mockList.get(0));
        Assert.assertEquals(1, mockList.size());

        //mockFruits names is using mockList, below asserts confirm it
        Assert.assertEquals("Apple", mockFruits.getNames().get(0));
        Assert.assertEquals(1, mockFruits.getNames().size());

        mockList.add(1, "Mango");
        //below will print null because mockList.get(1) is not stubbed
        System.out.println(mockList.get(1));
    }

}
