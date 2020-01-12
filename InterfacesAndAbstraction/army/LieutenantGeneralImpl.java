package InterfacesAndAbstraction.army;

import InterfacesAndAbstraction.army.Interfaces.LieutenantGeneral;


import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String secondName, double salary) {
        super(id, firstName, secondName, salary);
        this.privates = new TreeSet<>((f, s) -> s.getId() - f.getId());
    }


    @Override
    public void addPrivate(PrivateImpl soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());
        if (!this.privates.isEmpty()){


            for (PrivateImpl soldier : this.privates) {
                sb.append("  ").append(soldier.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
