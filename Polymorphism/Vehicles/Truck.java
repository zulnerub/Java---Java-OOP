package Polymorphism.Vehicles;

public class Truck extends Vehicle {
    private static final Double SUMMERTRUCKMULTIPLIER = 1.6;

    public Truck(Double fuel, Double consumption) {
        super(fuel, consumption);
    }

    @Override
    protected void drive(Double km) {
        Double result = (super.getConsumption() + SUMMERTRUCKMULTIPLIER) * km;
        if (super.getFuel() - result < 0){
            throw new IllegalArgumentException("Truck needs refueling");
        }
        super.setFuel(super.getFuel() - result);
    }

    @Override
    protected void refuel(Double lt) {
         super.setFuel(super.getFuel() + (lt * 0.95));
    }
}
