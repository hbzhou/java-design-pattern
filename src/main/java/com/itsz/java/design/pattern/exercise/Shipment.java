package com.itsz.java.design.pattern.exercise;

import com.itsz.java.design.pattern.exercise.shipper.ItemType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Shipment {
    private String shipmentId = UUID.randomUUID().toString();
    private String toAddress;
    private String fromAddress;
    private String toZipCode;
    private String fromZipCode;
    private ItemType itemType;
    private BigDecimal weight;
    private List<String> marks = new ArrayList<>();

    public Shipment() {
    }

    public Shipment(String toAddress, String fromAddress, String toZipCode, String fromZipCode, ItemType itemType, BigDecimal weight, List<String> marks) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.toZipCode = toZipCode;
        this.fromZipCode = fromZipCode;
        this.itemType = itemType;
        this.weight = weight;
        this.marks = marks;
    }

    public String ship(){
        return this.shipmentId;
    }
}
