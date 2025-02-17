package com.buildingblocks.actionsandshiftsmanager.domain.movement.entities;

import com.buildingblocks.actionsandshiftsmanager.domain.movement.values.PlaceId;
import com.buildingblocks.shared.domain.generic.Entity;

public class Place extends Entity<PlaceId> {

    private String type;

    public Place(String type) {
        super(new PlaceId());
        this.type = type;
    }

    public Place(PlaceId identity, String type) {
        super(identity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
