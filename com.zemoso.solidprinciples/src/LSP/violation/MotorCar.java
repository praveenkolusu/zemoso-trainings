package LSP.violation;

public class MotorCar implements Car{

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
