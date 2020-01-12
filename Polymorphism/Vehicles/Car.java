package Polymorphism.Vehicles;

public class Car extends Vehicle {
    private static final Double SUMMERMULTIPLIER = 0.9;

    public Car(Double fuel, Double consumption) {
        super(fuel, consumption);
    }

    @Override
    protected void drive(Double km) {
        Double result = km * (SUMMERMULTIPLIER + super.getConsumption());
        if (super.getFuel() - result < 0){
            throw new IllegalArgumentException("Car needs refueling");
        }
        super.setFuel(super.getFuel() - result);
    }

    @Override
    protected void refuel(Double lt) {
        super.setFuel(super.getFuel() + lt);
    }


}
