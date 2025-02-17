package com.buildingblocks.actionsandshiftsmanager.domain.playerphase.entities;

import com.buildingblocks.actionsandshiftsmanager.domain.playerphase.values.PlayerId;
import com.buildingblocks.shared.domain.generic.Entity;

public class Player extends Entity<PlayerId> {
    private String name;

    public Player( String name) {
        super(new PlayerId());
        this.name = name;
    }

    public Player(PlayerId identity, String name) {
        super(identity);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
