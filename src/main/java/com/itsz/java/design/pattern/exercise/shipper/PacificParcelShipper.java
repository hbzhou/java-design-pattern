package com.itsz.java.design.pattern.exercise.shipper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class PacificParcelShipper extends AbstractShipper {

    private final String[] supportedPrefix = {"A7", "A8", "A9"};

    private Map<ItemType, UnaryOperator<BigDecimal>> costCalculators;

    public PacificParcelShipper() {
        super("Pacific Parcel", "Based in San Diego");
        costCalculators = new HashMap<>();
        costCalculators.put(ItemType.LETTER, weight -> weight.multiply(new BigDecimal("0.51")));
        costCalculators.put(ItemType.PACKAGE, weight -> weight.multiply(new BigDecimal("0.19")));
        costCalculators.put(ItemType.OVER_SIZED, weight -> weight.multiply(new BigDecimal("0.21")));
    }

    @Override
    public boolean supports(String fromZipCode) {
        return Arrays.stream(supportedPrefix).anyMatch(fromZipCode::startsWith);
    }

    @Override
    public BigDecimal getCost(ItemType itemType, BigDecimal weight) {
        return costCalculators.get(itemType).apply(weight);
    }
}
