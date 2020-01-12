package InterfacesAndAbstraction.army.HelperClasses;

import InterfacesAndAbstraction.army.HelperClasses.Interfaces.Repair;

public class RepairImpl implements Repair {
    private String name;
    private String hoursWorked;

    public RepairImpl(String name, String hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %s", this.name, this.hoursWorked);
    }
}
