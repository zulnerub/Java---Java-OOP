package Abstractions.HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = rd.readLine().split("\\s+");

        double price = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Seasons season = Seasons.valueOf(tokens[2].toUpperCase());
        Discount discount = Discount.valueOf(tokens[3].toUpperCase());

        Reservation reservation  =new Reservation(price, days, season, discount);
        double result = PriceCalculator.calculate(reservation);
        System.out.println(String.format("%.2f", result));
    }
}
