package InterfacesAndAbstraction.army;

import InterfacesAndAbstraction.army.Enums.Corps;
import InterfacesAndAbstraction.army.HelperClasses.Interfaces.Repair;
import InterfacesAndAbstraction.army.Interfaces.Engineer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String secondName, double salary, Corps corps) throws IllegalArgumentException {
        super(id, firstName, secondName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.getRepairs();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());
        if (!repairs.isEmpty()){
            for (Repair repair : repairs) {
                sb.append("  ")
                        .append(repair.toString())
                        .append(System.lineSeparator());
            }
        }


        return sb.toString().trim();
    }
}
