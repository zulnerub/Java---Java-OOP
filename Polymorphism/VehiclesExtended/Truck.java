package Polymorphism.VehiclesExtended;

public class Truck extends Vehicle {
    private static final Double SUMMERTRUCKMULTIPLIER = 1.6;

    public Truck(Double fuel, Double consumption, Double tankCapacity) {
        super(fuel, consumption, tankCapacity);
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
        if (lt <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }else if (super.getFuel() + lt > super.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
         super.setFuel(super.getFuel() + (lt * 0.95));
    }
}
