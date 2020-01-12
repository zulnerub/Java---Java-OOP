package Abstractions.HotelReservation;
public class PriceCalculator {

    public static double calculate(Reservation reservation){
        double basePrice = reservation.getPricePerDay() * reservation.getNumberOfDays() * reservation.getSeason().getMultiplier();
        double percentDiscount = 1 - (reservation.getDiscount().getPercentDiscount() / 100.0) ;
        return basePrice * percentDiscount;
    }
}
