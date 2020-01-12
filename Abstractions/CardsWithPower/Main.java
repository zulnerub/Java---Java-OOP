package Abstractions.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String card = rd.readLine();
        String suit = rd.readLine();

        int power = Cards.valueOf(card).getValue() + Suits.valueOf(suit).getValue();

        System.out.printf("Card name: %s of %s; Card power: %d", card, suit, power);
    }
}
