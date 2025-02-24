package com.buildingblocks.actionsandshiftsmanager.application.moveByCard;

import com.buildingblocks.actionsandshiftsmanager.application.shared.MethodPerformed;
import com.buildingblocks.actionsandshiftsmanager.application.shared.repositories.IEventsRepository;
import com.buildingblocks.actionsandshiftsmanager.domain.movement.Movement;
import com.buildingblocks.actionsandshiftsmanager.domain.playerphase.PlayerPhase;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class MovementUseCase implements ICommandUseCase<MovementRequest, Mono<MovementResponse>> {
    private final IEventsRepository repository;

    public MovementUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<MovementResponse> execute(MovementRequest request) {
        Movement movement = new Movement();
        PlayerPhase playerPhase = new PlayerPhase();

        movement.modifiedMethodPerformed(request.getMethodPerformed().getId(), request.getMethodPerformed().getName(), request.getMethodPerformed().getDescription());
        movement.choosePlace(request.getTypePlace());

        playerPhase.cardDeleted(request.getCard().getId(), request.getCard().getName(), request.getCard().getType(), request.getCard().getAction());

        playerPhase.calculatedPoints(request.getPoints().getAmountPoints());

        playerPhase.getUncommittedEvents().forEach(repository::save);
        playerPhase.markEventsAsCommitted();

        playerPhase.playerChanged(request.getNextPlayerId(), request.getNextPlayerName());

        return Mono.just(
                new MovementResponse(
                        movement.getMethodPerformed().getName().getName(),
                        new MethodPerformed(
                                movement.getMethodPerformed().getIdentity().getValue(),
                                movement.getMethodPerformed().getName().getName(),
                                movement.getMethodPerformed().getDescription().getDescription()
                        ),
                        playerPhase.getAmountPoints().getAmountPoints()
                )
        );
    }
}
