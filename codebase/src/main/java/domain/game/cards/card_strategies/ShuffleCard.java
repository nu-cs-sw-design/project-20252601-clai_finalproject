package domain.game.cards.card_strategies;

import domain.game.CardType;
import domain.game.Game;
import domain.game.cards.Card;

import java.util.List;
import java.util.Random;

public class ShuffleCard implements CardStrategy {
    // declare internal states
    private final CardType cardType = CardType.SHUFFLE;

    // remove card from hand, return
    public GameTurnState action(GameTurnState gameTurnState) {
        return playShuffle(gameTurnState);
    }
    public CardType returnCardType() {
        // return proper card type
        return cardType;
    }
    private GameTurnState playShuffle(GameTurnState gameTurnState) {
        // randomize card selection
        List<Card> deck = gameTurnState.getDeck();

        Random rand = new Random();
        for (int deckIndex = deck.size() - 1; deckIndex > 0; deckIndex--) {
            int indexToSwap = rand.nextInt(deckIndex + 1);
            Card temporaryCard = deck.get(indexToSwap);
            deck.set(indexToSwap, deck.get(deckIndex));
            deck.set(deckIndex, temporaryCard);
        }

        // set deck in gameturnstate
        gameTurnState.setDeck(deck);
        return gameTurnState;
    }
}
