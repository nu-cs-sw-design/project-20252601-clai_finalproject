package domain.game;

public abstract class CardStrategy {
    abstract void action(int playerID);
    abstract void returnCardType();
}
