package domain.game.cards.card_strategies;

import domain.game.cards.Card;

import java.util.List;

public class GameTurnState {
    private List<Card> hand;
    private List<Card> deck;
    private boolean isPlayerDead;
    private int playerNumTurns;

    // initialize empty GameTurnState
    public GameTurnState(List<Card> hand, List<Card> deck) {
        this.hand = hand;
        this.deck = deck;
        isPlayerDead = false;
        playerNumTurns = 0;
    }

    // getters
    public boolean isPlayerDead() {
        return isPlayerDead;
    }
    public List<Card> getHand() {
        return hand;
    }
    public List<Card> getDeck() {
        return deck;
    }
    public int getPlayerNumTurns() {
        return playerNumTurns;
    }

    // setters
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
    public void setIsPlayerDead(boolean isPlayerDead) {
        this.isPlayerDead = isPlayerDead;
    }
    public void setPlayerNumTurns(int playerNumTurns) {
        this.playerNumTurns = playerNumTurns;
    }
}
