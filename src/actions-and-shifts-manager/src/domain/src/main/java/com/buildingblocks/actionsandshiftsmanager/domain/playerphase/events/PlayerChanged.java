package com.buildingblocks.actionsandshiftsmanager.domain.playerphase.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerChanged extends DomainEvent {
    private final String id;
    private final String name;

    public PlayerChanged(String id, String name) {
        super(EventsEnum.PLAYER_CHANGED.name());
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
