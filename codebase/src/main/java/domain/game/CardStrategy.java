package domain.game;

import java.util.List;

public abstract class CardStrategy {
    abstract List<Card> action(List<Card> deck);
    abstract CardType returnCardType();
}
