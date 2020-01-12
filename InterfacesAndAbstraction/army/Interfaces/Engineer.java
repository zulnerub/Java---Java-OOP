package InterfacesAndAbstraction.army.Interfaces;


import InterfacesAndAbstraction.army.HelperClasses.Interfaces.Repair;

import java.util.Collection;


public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
