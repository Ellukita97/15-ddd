package com.buildingblocks.actionsandshiftsmanager.domain.movement;

import com.buildingblocks.actionsandshiftsmanager.domain.movement.entities.MethodPerformed;
import com.buildingblocks.actionsandshiftsmanager.domain.movement.entities.Place;
import com.buildingblocks.actionsandshiftsmanager.domain.movement.events.ChosenPlace;
import com.buildingblocks.actionsandshiftsmanager.domain.movement.events.ModifiedMethodPerformed;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;

public class MovementHandler extends DomainActionsContainer {
    public MovementHandler(Movement movement) {
        add((ChosenPlace event) -> {
            Place place = new Place( event.getType(), 1);
            movement.setPlace(place);
        });
        add((ModifiedMethodPerformed event) -> {
            MethodPerformed methodPerformed = new MethodPerformed(event.getName(), event.getDescription());
            movement.setMethodPerformed(methodPerformed);
        });
    }
}
