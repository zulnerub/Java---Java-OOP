package InterfacesAndAbstraction.Car;

public class Seat implements Car {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        String format = "This is %s produced in %s and have %d tires.";

        return String.format(format, this.getModel(), this.countryProduced, TIRES);
    }
}
