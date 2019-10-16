package com.infy.tdd.training.mock;

/**
 * Created by rishi.khurana on 2/3/2019.
 */
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;


public class AMockitoMockMethodExample {

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        // using Mockito.mock() method, creating a mock object of List Class
        List<String> mockList = Mockito.mock(List.class);

        // Specifying mock list to return 5, when ever size method of mockList is Invoked.
        Mockito.when(mockList.size()).thenReturn(5);

        // Asserting / Validating size.
        assert(mockList.size()==5);
    }

}