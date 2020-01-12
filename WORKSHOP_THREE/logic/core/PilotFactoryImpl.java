package WORKSHOP_THREE.logic.core;

import WORKSHOP_THREE.logic.core.interfaces.PilotFactory;
import WORKSHOP_THREE.logic.entities.PilotImpl;
import WORKSHOP_THREE.logic.entities.interfaces.Pilot;

public class PilotFactoryImpl implements PilotFactory {
    @Override
    public Pilot createPilot(String name) {
        return new PilotImpl(name);
    }
}
