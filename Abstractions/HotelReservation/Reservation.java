package Abstractions.HotelReservation;

public class Reservation {

    private double pricePerDay;
    private int numberOfDays;
    private Seasons season;
    private Discount discount;

    public Reservation(double pricePerDay, int numberOfDays, Seasons season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Seasons getSeason() {
        return season;
    }

    public Discount getDiscount() {
        return discount;
    }
}
