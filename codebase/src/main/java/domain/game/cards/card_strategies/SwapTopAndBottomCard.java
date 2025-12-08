package domain.game.cards.card_strategies;

import domain.game.CardType;
import domain.game.Game;
import domain.game.cards.Card;

import java.util.List;

public class SwapTopAndBottomCard implements CardStrategy {
    // declare internal states
    private final CardType cardType = CardType.SWAP_TOP_AND_BOTTOM;

    // remove card from hand, return
    public GameTurnState action(GameTurnState gameTurnState) {
        return playSwapTopAndBottom(gameTurnState);
    }
    public CardType returnCardType() {
        // return proper card type
        return cardType;
    }
    private GameTurnState playSwapTopAndBottom(GameTurnState gameTurnState) {
        // get deck
        List<Card> deck = gameTurnState.getDeck();

        // sanity check
        if (deck.size() < 2) return gameTurnState;

        // get top, bottom card
        Card top = deck.remove(0);
        Card bottom = deck.remove(deck.size() - 1);

        // reinsert cards to top and bottom
        deck.add(0, bottom);
        deck.add(top);

        // set gameturnstate
        gameTurnState.setDeck(deck);
        return gameTurnState;
    }
}
