package com.itsz.java.design.pattern.exercise.shipper;

public class PacificParcelShipperFactory implements ShipperFactory<Shipper>{



    @Override
    public Shipper create(String name, String base) {
        return new PacificParcelShipper(name, base);
    }
}
