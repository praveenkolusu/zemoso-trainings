package factory;

public class OnlineOrderProcessingFactory {
    private final OrderFactory orderFactory;

    public OnlineOrderProcessingFactory(OrderFactory orderFactory) {
        this.orderFactory = orderFactory;
    }

    public Order processOrder() {
        return orderFactory.createOrder();
    }
}