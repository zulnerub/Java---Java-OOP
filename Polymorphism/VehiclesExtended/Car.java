package Polymorphism.VehiclesExtended;

public class Car extends Vehicle {
    private static final Double SUMMERMULTIPLIER = 0.9;

    public Car(Double fuel, Double consumption, Double tankCapacity) {
        super(fuel, consumption, tankCapacity);
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
        if (lt <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }else if (super.getFuel() + lt > super.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuel(super.getFuel() + lt);
    }


}
