package Polymorphism.VehiclesExtended;

public abstract class Vehicle {
    protected Double fuel;
    protected Double consumption;
    protected Double tankCapacity;

    public Vehicle(Double fuel, Double consumption, Double tankCapacity) {
        this.setFuel(fuel);
        this.setConsumption(consumption);
        this.setTankCapacity(tankCapacity);
    }

    protected abstract void drive(Double km);
    protected abstract void refuel(Double lt);


    public Double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public Double getFuel() {
        return this.fuel;
    }

    protected void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    public Double getConsumption() {
        return this.consumption;
    }

    protected void setConsumption(Double consumption) {
        this.consumption = consumption;
    }
}
