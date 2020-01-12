package Polymorphism.VehiclesExtended;

public class Bus extends Vehicle {
    private boolean isEmpty;

    public Bus(Double fuel, Double consumption, Double tankCapacity) {
        super(fuel, consumption, tankCapacity);
        this.setEmpty(true);
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    protected void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    protected void drive(Double km) {
        double multiplier = 0;
        if (!this.isEmpty){
            multiplier = 1.4;
        }
        Double result = (super.getConsumption()+ multiplier) * km;
        if (super.getFuel() - result < 0){
            throw new IllegalArgumentException("Bus needs refueling");
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
