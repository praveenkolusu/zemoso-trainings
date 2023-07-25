package factory;

public class ElectronicsOrder implements Order {
    @Override
    public String processOrder() {
        return "Processing Electronic Order...";
    }
}
