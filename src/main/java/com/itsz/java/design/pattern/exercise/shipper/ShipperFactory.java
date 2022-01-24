package com.itsz.java.design.pattern.exercise.shipper;

public interface ShipperFactory<Shipper> {

    Shipper create(String name, String base);

}
