package com.itsz.java.design.pattern.exercise.shipper;

public class AirEastShipperFactory implements ShipperFactory<Shipper>{

    @Override
    public Shipper create(String name, String base) {
        return new AirEastShipper(name, base);
    }
}
