package factory;

public class ClothingOrderFactory implements OrderFactory {
    @Override
    public Order createOrder() {
        return new ClothingOrder();
    }
}