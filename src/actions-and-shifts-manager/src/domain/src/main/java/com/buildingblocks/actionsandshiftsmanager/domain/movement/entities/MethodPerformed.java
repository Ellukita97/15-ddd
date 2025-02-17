package com.buildingblocks.actionsandshiftsmanager.domain.movement.entities;

import com.buildingblocks.actionsandshiftsmanager.domain.movement.values.MethodPerformedId;
import com.buildingblocks.shared.domain.generic.Entity;

public class MethodPerformed extends Entity<MethodPerformedId> {
    private String name;
    private String description;

    public MethodPerformed( String name, String description) {
        super(new MethodPerformedId());
        this.name = name;
        this.description = description;
    }

    public MethodPerformed(MethodPerformedId identity, String name, String description) {
        super(identity);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
