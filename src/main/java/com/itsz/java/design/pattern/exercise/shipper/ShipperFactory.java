package com.itsz.java.design.pattern.exercise.shipper;

import java.util.Arrays;
import java.util.List;

public class ShipperFactory {

    private static final List<Shipper> shippers = Arrays.asList(
            new PacificParcelShipper(),
            new ChicagoSprintShipper(),
            new AirEastShipper()
    );

    public static Shipper getShipper(String fromZipCode) {
        return shippers.stream()
                .filter(shipper -> shipper.supports(fromZipCode))
                .findFirst()
                .orElse(new AirEastShipper());
    }

}
