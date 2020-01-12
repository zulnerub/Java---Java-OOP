package InterfacesAndAbstraction.Ferrari;

public class Ferrari implements Car{
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        String format = "%s/%s/%s/%s";
        return String.format(format, this.model, brakes(), gas(), this.driverName);
    }
}
