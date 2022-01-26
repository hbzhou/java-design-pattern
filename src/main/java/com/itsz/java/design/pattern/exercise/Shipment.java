package com.itsz.java.design.pattern.exercise;

import com.itsz.java.design.pattern.exercise.shipper.ItemType;
import com.itsz.java.design.pattern.exercise.shipper.ShipperFactory;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Shipment {
    private String shipmentId;
    private String toAddress;
    private String fromAddress;
    private String toZipCode;
    private String fromZipCode;
    private ItemType itemType;
    private BigDecimal weight;
    private List<Mark> marks;

    public String ship(){
        BigDecimal cost = ShipperFactory.getShipper(this.fromZipCode).getCost(this.itemType, this.weight);
        StringBuilder builder = new StringBuilder();
        builder.append("Shipment with the ID ").append(this.shipmentId);
        builder.append(" will be picked up from ").append(this.fromZipCode).append(" ").append(this.fromAddress);
        builder.append(" and shipped to ").append(this.toZipCode).append(" ").append(this.toAddress).append(".");
        builder.append("\n");
        builder.append("Cost = ").append(cost).append(".");
        builder.append("\n");
        for (Mark mark : this.marks) {
            builder.append(mark.getDescription());
            builder.append("\n");
        }
        System.out.println(builder.toString());
        return this.shipmentId;
    }
}
