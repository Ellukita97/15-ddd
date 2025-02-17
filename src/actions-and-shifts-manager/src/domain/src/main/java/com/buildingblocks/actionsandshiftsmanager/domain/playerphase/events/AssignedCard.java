package com.buildingblocks.actionsandshiftsmanager.domain.playerphase.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class AssignedCard extends DomainEvent {
    private final String name;
    private final String type;
    private final String effect;

    public AssignedCard(String name, String type, String effect) {
        super(EventsEnum.ASSIGNED_CARD.name());
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getEffect() {
        return effect;
    }
}
