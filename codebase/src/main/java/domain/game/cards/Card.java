package domain.game.cards;

import domain.game.CardType;
import domain.game.cards.card_strategies.CardStrategy;
import domain.game.cards.card_strategies.NopeCard;
import domain.game.cards.card_strategies.ShuffleCard;
import domain.game.cards.card_strategies.SwapTopAndBottomCard;

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
		
		if (cardType == CardType.NOPE) {
			CardActionStrategy = new NopeCard();
		} else if (cardType == CardType.SHUFFLE) {
            CardActionStrategy = new ShuffleCard();
        } else if (cardType == CardType.SWAP_TOP_AND_BOTTOM) {
            CardActionStrategy = new SwapTopAndBottomCard();
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

	public List<Card> playCard(List<Card> deck) {	
		return CardActionStrategy.action(deck);
	}
}

