package domain.game.cards;

import domain.game.CardType;
import domain.game.cards.card_strategies.*;

import java.util.List;

public class Card {
	private CardType cardType;
	private boolean isMarked;
	private boolean isFacedUp;
	private CardStrategy CardActionStrategy;

	public Card(domain.game.CardType cardType) {
		this.isMarked = false;
		this.cardType = cardType;
		this.isFacedUp = false;
		
		if (cardType == CardType.NOPE) { // maybe create factory object instead?
			CardActionStrategy = new NopeCard();
		} else if (cardType == CardType.SHUFFLE) {
            CardActionStrategy = new ShuffleCard();
        } else if (cardType == CardType.SWAP_TOP_AND_BOTTOM) {
            CardActionStrategy = new SwapTopAndBottomCard();
        } else if (cardType == CardType.EXPLODING_KITTEN) {
            CardActionStrategy = new ExplodingKittenCard();
        } else {
            CardActionStrategy = null;
        }
	}

	public domain.game.CardType getCardType() {
		return cardType;
	}

	public void markCard() {
		isMarked = true;
	}

	public boolean checkIfMarked() {
		return isMarked;
	}

	public void setFacedUp() {
		isFacedUp = true;
	}

	public boolean checkIfFacedUp() {
		return isFacedUp;
	}

	public GameTurnState playCard(GameTurnState gameTurnState) {
		return CardActionStrategy.action(gameTurnState);
	}
}

