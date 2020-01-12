package WORKSHOP_ONE.viceCity;

import WORKSHOP_ONE.viceCity.core.ControllerImpl;
import WORKSHOP_ONE.viceCity.core.EngineImpl;
import WORKSHOP_ONE.viceCity.core.interfaces.Controller;
import WORKSHOP_ONE.viceCity.core.interfaces.Engine;


public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
