package com.itsz.java.design.pattern.exercise.shipper;

public abstract class AbstractShipper implements Shipper{

    protected String name;
    protected String base;

    public AbstractShipper(String name, String base) {
        this.name = name;
        this.base  = base;
    }

}
