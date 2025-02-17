package com.buildingblocks.actionsandshiftsmanager.domain.playerphase.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class ModifiedPoints extends DomainEvent {
    private final String id;
    private final int amountPoints;

    public ModifiedPoints(String id, int amountPoints) {
        super(EventsEnum.MODIFIED_POINTS.name());
        this.id = id;
        this.amountPoints = amountPoints;
    }

    public String getId() {
        return id;
    }

    public int getAmountPoints() {
        return amountPoints;
    }
}
