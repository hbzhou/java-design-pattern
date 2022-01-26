package com.itsz.java.design.pattern.exercise;

import com.itsz.java.design.pattern.exercise.shipper.ItemType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        Shipment shipment = Shipment.builder()
                .shipmentId(UUID.randomUUID().toString())
                .fromAddress("4th Ave SE, Bellevue, Wa 92021 ")
                .fromZipCode("12292")
                .toZipCode("1313")
                .toAddress("Mockingbird Lane, Tulsa, OK 67721")
                .itemType(ItemType.LETTER)
                .weight(new BigDecimal("200"))
                .marks(Arrays.asList(Mark.FRAGILE, Mark.DO_NOT_LEAVE, Mark.RETURN_RECEIPT_REQUESTED))
                .build();
        shipment.ship();
    }
}
