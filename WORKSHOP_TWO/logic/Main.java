package WORKSHOP_TWO.logic;

import WORKSHOP_TWO.logic.common.InputInterpreter;
import WORKSHOP_TWO.logic.core.Engine;
import WORKSHOP_TWO.logic.core.ManagerControllerImpl;
import WORKSHOP_TWO.logic.core.interfaces.ManagerController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ManagerController managerController = new ManagerControllerImpl();
        InputInterpreter inputInterpreter = new InputInterpreter();

        Engine engine = new Engine(managerController, inputInterpreter);
        engine.run();
    }
}
