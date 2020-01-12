package WORKSHOP_ONE.viceCitySecondPart;

import WORKSHOP_ONE.viceCitySecondPart.core.ControllerImpl;
import WORKSHOP_ONE.viceCitySecondPart.core.EngineImpl;
import WORKSHOP_ONE.viceCitySecondPart.core.interfaces.Controller;
import WORKSHOP_ONE.viceCitySecondPart.core.interfaces.Engine;


public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
