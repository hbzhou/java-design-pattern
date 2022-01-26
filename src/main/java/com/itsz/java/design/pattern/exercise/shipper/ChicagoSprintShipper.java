package com.itsz.java.design.pattern.exercise.shipper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class ChicagoSprintShipper extends AbstractShipper{

    private final String[] supportedPrefix = {"A4", "A5", "A6"};
    private Map<ItemType, UnaryOperator<BigDecimal>> costCalculators;

    public ChicagoSprintShipper() {
        super("Chicago Sprint", "Based in a suburb of Chicago");
        costCalculators = new HashMap<>();
        costCalculators.put(ItemType.LETTER, weight -> weight.multiply(new BigDecimal("0.42")));
        costCalculators.put(ItemType.PACKAGE, weight -> weight.multiply(new BigDecimal("0.20")));
        costCalculators.put(ItemType.OVER_SIZED, weight -> new BigDecimal("0.20").multiply(new BigDecimal("160")));
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
