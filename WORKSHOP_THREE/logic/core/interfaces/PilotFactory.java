package WORKSHOP_THREE.logic.core.interfaces;

import WORKSHOP_THREE.logic.entities.interfaces.Pilot;

public interface PilotFactory {
    Pilot createPilot(String name);
}
