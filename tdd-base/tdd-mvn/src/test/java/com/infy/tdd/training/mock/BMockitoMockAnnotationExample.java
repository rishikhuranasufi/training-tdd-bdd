package com.infy.tdd.training.mock;

/**
 * Created by rishi.khurana on 2/3/2019.
 */
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BMockitoMockAnnotationExample {

    public static final String RISHI_KHURANA = "rishi.khurana";

    //It’s useful when we want to use the mocked object at multiple places
    // because we avoid calling mock() method multiple times,
    // as specified in Example AMockitoMockMethodExample.
    @Mock
    List<String> mockList;

    @Before
    public void setup() {
        //if we don't call below, we will get NullPointerException
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        when(mockList.get(0)).thenReturn(RISHI_KHURANA);
        Assert.assertEquals(RISHI_KHURANA, mockList.get(0));
    }

}