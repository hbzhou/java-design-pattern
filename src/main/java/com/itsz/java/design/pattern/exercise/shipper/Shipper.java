package com.itsz.java.design.pattern.exercise.shipper;

import java.math.BigDecimal;

public interface Shipper {

    boolean supports (String fromZipCode);

    BigDecimal getCost(ItemType itemType, BigDecimal weight);

}
