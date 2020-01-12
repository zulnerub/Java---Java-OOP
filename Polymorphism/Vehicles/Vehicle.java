package Polymorphism.Vehicles;

public abstract class Vehicle {
    protected Double fuel;
    protected Double consumption;

    public Vehicle(Double fuel, Double consumption) {
        this.setFuel(fuel);
        this.setConsumption(consumption);
    }

    protected abstract void drive(Double km);
    protected abstract void refuel(Double lt);


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
