package com.infy.tdd.training;

import com.infy.tdd.training.exception.NameNotFoundException;

/**
 * Created by EQS on 8/2/2018.
 */

public class CustomerService {

    public String findByName(String name) throws NameNotFoundException {
        if ("".equals(name)) {
            throw new NameNotFoundException(666, "Name is empty!");
        }
        //Either create a CustomerService Object and return it.
        return name;
    }

}
