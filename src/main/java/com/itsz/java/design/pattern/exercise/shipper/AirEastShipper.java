package com.itsz.java.design.pattern.exercise.shipper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class AirEastShipper extends AbstractShipper {

    private final String[] supportedPrefix = {"1", "2", "3"};
    private  Map<ItemType, UnaryOperator<BigDecimal>> costCalculators;

    public AirEastShipper() {
        super("Air East", "Based in Atlanta");
        costCalculators =  new HashMap<>();
        costCalculators.put(ItemType.LETTER, weight -> weight.multiply(new BigDecimal("0.39")));
        costCalculators.put(ItemType.PACKAGE, weight -> weight.multiply(new BigDecimal("0.25")));
        costCalculators.put(ItemType.OVER_SIZED, weight -> weight.multiply(new BigDecimal("0.39")).add(new BigDecimal("10")));
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
