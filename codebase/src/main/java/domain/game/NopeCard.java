package domain.game;

import java.util.List;

public class NopeCard extends CardStrategy {
    // declare internal states
    private final CardType cardType = CardType.NOPE;

    // remove card from hand, return
    public List<Card> action(List<Card> deck) {
        return playNope(deck);
    }
    public CardType returnCardType() {
        // return proper card type
        return CardType.NOPE;
    }
    private List<Card> playNope(List<Card> playerHand) {
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
        // return player hand
        return playerHand;
    }
}
