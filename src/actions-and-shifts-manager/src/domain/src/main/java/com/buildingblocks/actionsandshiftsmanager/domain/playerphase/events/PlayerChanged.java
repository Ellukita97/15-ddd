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

    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
