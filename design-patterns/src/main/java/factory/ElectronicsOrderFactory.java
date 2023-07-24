package factory;

public class ElectronicsOrderFactory implements OrderFactory {
    @Override
    public Order createOrder() {
        return new ElectronicsOrder();
    }
}
