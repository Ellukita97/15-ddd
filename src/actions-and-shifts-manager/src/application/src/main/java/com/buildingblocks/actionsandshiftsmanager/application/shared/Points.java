package com.buildingblocks.actionsandshiftsmanager.application.shared;

public class Points {
    private String id;
    private Integer amountPoints;

    public Points(String id, Integer amountPoints) {
        this.id = id;
        this.amountPoints = amountPoints;
    }

    public String getId() {
        return id;
    }

    public Integer getAmountPoints() {
        return amountPoints;
    }
}
