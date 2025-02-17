package com.buildingblocks.actionsandshiftsmanager.domain.playerphase.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class AssignedPlayer extends DomainEvent {
    private final String name;

    public AssignedPlayer(String name) {
        super(EventsEnum.ASSIGNED_PLAYER.name());
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
