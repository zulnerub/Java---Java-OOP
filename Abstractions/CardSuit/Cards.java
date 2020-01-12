package Abstractions.CardSuit;

public enum Cards {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    public int value;

    Cards(int value) {
        this.value = value;
    }


}
