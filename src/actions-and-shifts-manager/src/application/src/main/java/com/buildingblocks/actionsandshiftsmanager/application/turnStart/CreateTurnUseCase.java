package com.buildingblocks.actionsandshiftsmanager.application.turnStart;

import com.buildingblocks.actionsandshiftsmanager.application.shared.repositories.IEventsRepository;
import com.buildingblocks.actionsandshiftsmanager.application.shared.Card;
import com.buildingblocks.actionsandshiftsmanager.domain.playerphase.PlayerPhase;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class CreateTurnUseCase implements ICommandUseCase<CreateTurnRequest, Mono<CreateTurnResponse>> {

    private final IEventsRepository repository;

    public CreateTurnUseCase(IEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<CreateTurnResponse> execute(CreateTurnRequest request) {
        PlayerPhase playerPhase = new PlayerPhase();

        playerPhase.assignedPlayer(request.getPlayerName());
        playerPhase.assignedCard(request.getCard().getName(), request.getCard().getType(), request.getCard().getAction());
        Card card = new Card(request.getCard().getName(), request.getCard().getType(), request.getCard().getAction());

        playerPhase.getUncommittedEvents().forEach(repository::save);
        playerPhase.markEventsAsCommitted();

        playerPhase.modifiedPoints(request.getPoints().getId(), request.getPoints().getAmountPoints());

        return Mono.just(
                new CreateTurnResponse(
                        playerPhase.getPlayer().getName().getName(),
                        playerPhase.getAmountPoints().getAmountPoints(),
                        card,
                        request.getCardList()
                )
        );
    }
}
