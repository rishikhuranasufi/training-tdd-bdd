package com.infy.tdd.training;

import java.util.Objects;

/**
 * Created by EQS on 8/2/2018.
 */
public class Fruit {

    public Fruit(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    private String name;
    private int qty;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Test equal, override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return qty == fruit.qty &&
                Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, qty);
    }
}
