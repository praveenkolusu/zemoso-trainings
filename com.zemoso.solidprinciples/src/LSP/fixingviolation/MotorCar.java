package LSP.fixingviolation;

import LSP.violation.Car;
import LSP.violation.Engine;

public class MotorCar implements EngineCar {

    private Engine engine;
    public MotorCar(Engine engine) {
        this.engine = engine;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void turnOnEngine() {
        engine.on();
    }

    public void accelerate() {
        engine.powerOn();
    }
}
