package domain.game.cards.card_strategies;

import domain.game.CardType;
import domain.game.Game;
import domain.game.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class NopeCard implements CardStrategy {
    // declare internal states
    private final CardType cardType = CardType.NOPE;

    // remove card from hand, return
    public GameTurnState action(GameTurnState gameTurnState) {
        return playNope(gameTurnState);
    }
    public CardType returnCardType() {
        // return proper card type
        return CardType.NOPE;
    }
    private GameTurnState playNope(GameTurnState gameTurnState) {
        // extract playerHand from gameturnstate
        List<Card> playerHand = gameTurnState.getHand();

        // remove card from hand
        Card deletedCard = null;
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).getCardType() == cardType) {
                deletedCard = playerHand.remove(i);
                if (deletedCard == null) {
                    System.out.println("ERROR: Could not delete card.");
                }
                break;
            }
        }

        // set playerhand in gameturnstate
        gameTurnState.setHand(playerHand);

        // return player hand
        return gameTurnState;
    }
}
