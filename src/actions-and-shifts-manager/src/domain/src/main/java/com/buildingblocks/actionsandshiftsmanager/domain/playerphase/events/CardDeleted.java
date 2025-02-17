package com.buildingblocks.actionsandshiftsmanager.domain.playerphase.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardDeleted extends DomainEvent {
    private final String id;
    private final String name;
    private final String type;
    private final String effect;

    public CardDeleted(String id, String name, String type, String effect) {
        super(EventsEnum.CARD_DELETED.name());
        this.id = id;
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    public String getId() {
        return id;
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
