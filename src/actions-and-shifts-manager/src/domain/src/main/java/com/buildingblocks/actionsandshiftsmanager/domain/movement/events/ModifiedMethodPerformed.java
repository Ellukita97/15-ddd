package com.buildingblocks.actionsandshiftsmanager.domain.movement.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class ModifiedMethodPerformed extends DomainEvent {
    private final String id;
    private final String name;
    private final String description;

    public ModifiedMethodPerformed(String id, String name, String description) {
        super(EventsEnum.MODIFIED_METHOD_PERFORMED.name());
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
