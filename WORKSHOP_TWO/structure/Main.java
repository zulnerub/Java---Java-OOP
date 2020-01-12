package WORKSHOP_TWO.structure;

import WORKSHOP_TWO.structure.common.InputInterpreter;
import WORKSHOP_TWO.structure.core.Engine;
import WORKSHOP_TWO.structure.core.ManagerControllerImpl;
import WORKSHOP_TWO.structure.core.interfaces.ManagerController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ManagerController managerController = new ManagerControllerImpl();
        InputInterpreter inputInterpreter = new InputInterpreter();

        Engine engine = new Engine(managerController, inputInterpreter);
        engine.run();
    }
}
