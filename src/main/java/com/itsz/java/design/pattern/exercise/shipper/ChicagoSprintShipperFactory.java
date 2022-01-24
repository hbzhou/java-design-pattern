package com.itsz.java.design.pattern.exercise.shipper;

public class ChicagoSprintShipperFactory implements ShipperFactory<Shipper>{

    @Override
    public Shipper create(String name, String base) {
        return new ChicagoSprintShipper(name, base);
    }
}
