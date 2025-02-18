package com.buildingblocks.actionsandshiftsmanager.domain.movement.entities;

import com.buildingblocks.actionsandshiftsmanager.domain.movement.values.PlaceId;
import com.buildingblocks.shared.domain.generic.Entity;

public class Place extends Entity<PlaceId> {

    private String type;
    private int diseaseLevel;

    public Place(String type, int diseaseLevel) {
        super(new PlaceId());
        canGo(type,diseaseLevel);
    }

    public Place(PlaceId identity, String type, int diseaseLevel) {
        super(identity);
        canGo(type,diseaseLevel);
    }

    public void canGo(String type, int diseaseLevel) {
        if (diseaseLevel <= 3) {
            throw new Error("the disease level is very high, cant go");
        }else {
            this.type = type;
            this.diseaseLevel = diseaseLevel;
        }
    }

    public String getType() {
        return type;
    }

    public int getDiseaseLevel() {
        return diseaseLevel;
    }
}
