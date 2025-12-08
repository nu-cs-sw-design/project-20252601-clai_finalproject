package domain.game.cards.card_strategies;

import domain.game.CardType;
import domain.game.cards.Card;

import java.util.List;

public class ExplodingKittenCard implements CardStrategy {
    // declare internal states
    private final CardType cardType = CardType.EXPLODING_KITTEN;

    // remove card from hand, return
    public GameTurnState action(GameTurnState gameTurnState) {
        return playExplodingKitten(gameTurnState);
    }
    public CardType returnCardType() {
        // return proper card type
        return cardType;
    }
    private GameTurnState playExplodingKitten(GameTurnState gameTurnState) {
        // get deck
        List<Card> hand = gameTurnState.getHand();
        boolean doesHaveCard = false;
        for  (Card card : hand) {
            if (card.getCardType() == CardType.DEFUSE) {
                doesHaveCard = true;
            }
        }
        if (doesHaveCard) return gameTurnState;

        // set player dead
        gameTurnState.setIsPlayerDead(true);
        gameTurnState.setPlayerNumTurns(0);

        return gameTurnState;
    }
}
