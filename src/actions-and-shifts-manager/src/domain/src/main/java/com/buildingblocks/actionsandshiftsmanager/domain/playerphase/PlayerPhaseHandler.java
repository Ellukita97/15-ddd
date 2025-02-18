package com.buildingblocks.actionsandshiftsmanager.domain.playerphase;

import com.buildingblocks.actionsandshiftsmanager.domain.playerphase.events.*;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;

public class PlayerPhaseHandler extends DomainActionsContainer {
    public PlayerPhaseHandler(PlayerPhase playerPhase) {
        add((AssignedPlayer event) -> {
            playerPhase.assignedPlayer(event.getName());
        });
        add((AssignedCard event) -> {
            playerPhase.assignedCard(event.getName(), event.getType(), event.getEffect());
        });
        add((CalculatedPoints event) -> {
            playerPhase.calculatedPoints(event.getAmountPoints());
        });
        add((CardDeleted event) -> {
            playerPhase.cardDeleted(event.getId(), event.getName(), event.getType(), event.getEffect());
        });
        add((ModifiedPoints event) -> {
            playerPhase.modifiedPoints(event.getId(),event.getAmountPoints());
        });
        add((PlayerChanged event) -> {
            playerPhase.playerChanged(event.getId(),event.getName());
        });
    }
}
