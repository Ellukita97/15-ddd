package com.buildingblocks.actionsandshiftsmanager.domain.playerphase.entities;

import com.buildingblocks.actionsandshiftsmanager.domain.playerphase.values.CardId;
import com.buildingblocks.shared.domain.generic.Entity;

public class Card extends Entity<CardId> {
    private String name;
    private String type;
    private String action;

    public Card( String name, String type, String action) {
        super(new CardId());
        this.name = name;
        this.type = type;
        this.action = action;
    }

    public Card(CardId identity, String name, String type, String action) {
        super(identity);
        this.name = name;
        this.type = type;
        this.action = action;
    }

    public static int cardPoints(String text) {
        text = String.format(text).toUpperCase();
        return switch (text) {
            case "ROJO" -> 1;
            case "AMARILLO" -> 2;
            case "AZUL" -> 3;
            case "NEGRO" -> 4;
            default -> 0;
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
