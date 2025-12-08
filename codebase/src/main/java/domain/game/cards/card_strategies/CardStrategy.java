package domain.game.cards.card_strategies;

import domain.game.CardType;
import domain.game.cards.Card;

import java.util.List;

public interface CardStrategy {
     GameTurnState action(GameTurnState gameTurnState);
     CardType returnCardType();
}
