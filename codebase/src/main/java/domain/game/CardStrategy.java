package domain.game;

import java.util.List;

public interface CardStrategy {
    abstract List<Card> action(List<Card> deck);
    abstract CardType returnCardType();
}
