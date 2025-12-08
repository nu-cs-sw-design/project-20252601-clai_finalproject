package domain.game.cards.card_strategies;

import domain.game.CardType;
import domain.game.cards.Card;

import java.util.List;

public interface CardStrategy {
    List<Card> action(List<Card> deck);
    CardType returnCardType();
}
