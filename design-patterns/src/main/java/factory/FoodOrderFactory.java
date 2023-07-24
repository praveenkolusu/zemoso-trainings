package factory;

public class FoodOrderFactory implements OrderFactory {
    @Override
    public Order createOrder() {
        return new FoodOrder();
    }
}