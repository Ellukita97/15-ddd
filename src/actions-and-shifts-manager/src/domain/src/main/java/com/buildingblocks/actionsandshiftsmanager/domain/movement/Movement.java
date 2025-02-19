package com.buildingblocks.actionsandshiftsmanager.domain.movement;import com.buildingblocks.actionsandshiftsmanager.domain.movement.entities.MethodPerformed;import com.buildingblocks.actionsandshiftsmanager.domain.movement.entities.Place;import com.buildingblocks.actionsandshiftsmanager.domain.movement.events.ChosenPlace;import com.buildingblocks.actionsandshiftsmanager.domain.movement.events.ModifiedMethodPerformed;import com.buildingblocks.actionsandshiftsmanager.domain.movement.values.MovementId;import com.buildingblocks.shared.domain.generic.AggregateRoot;import com.buildingblocks.shared.domain.generic.DomainEvent;import java.util.List;public class Movement extends AggregateRoot<MovementId> {    private Place place;    private MethodPerformed methodPerformed;    //region Contructors    public Movement() {        super(new MovementId());        subscribe(new MovementHandler(this));    }    private Movement(MovementId identity) {        super(identity);        subscribe(new MovementHandler(this));    }    //endregion    //region getters and setters    public Place getPlace() {        return place;    }    public void setPlace(Place place) {        this.place = place;    }    public MethodPerformed getMethodPerformed() {        return methodPerformed;    }    public void setMethodPerformed(MethodPerformed methodPerformed) {        this.methodPerformed = methodPerformed;    }    //endregion    //region Domain Actions    public void choosePlace(String type) {        apply(new ChosenPlace(type));    }    public void modifiedMethodPerformed(String id, String name, String description) {        apply(new ModifiedMethodPerformed(id, name, description));    }    public static Movement from(final String identity, final List<DomainEvent> events) {        Movement movement = new Movement(MovementId.of(identity));        events.forEach(movement::apply);        return movement;    }    //endregion}