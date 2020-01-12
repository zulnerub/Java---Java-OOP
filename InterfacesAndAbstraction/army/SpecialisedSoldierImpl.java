package InterfacesAndAbstraction.army;

import InterfacesAndAbstraction.army.Enums.Corps;
import InterfacesAndAbstraction.army.Interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String secondName, double salary, Corps corps) throws IllegalArgumentException {
        super(id, firstName, secondName, salary);
        this.setCorps(corps);
    }

    public void setCorps(Corps corps) throws IllegalArgumentException {
        if (!corps.name().equals("Airforces") && !corps.name().equals("Marines")){
            throw new IllegalArgumentException();
        }

        this.corps = corps;
    }

    @Override
    public Corps getCorps(){
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCorps: " + this.getCorps().toString();
    }
}
