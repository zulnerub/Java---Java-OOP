package Abstractions.CardSuitTwo;

public class Main {
    public static void main(String[] args) {


        System.out.println("Card Ranks:");
        for (Cards card :
                Cards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card);
        }
    }
}
