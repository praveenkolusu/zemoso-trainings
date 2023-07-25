package factory;

class OrderProcessingFactory {
    public Order createOrder(String orderType) {
        return switch (orderType.toLowerCase()) {
            case "food" -> new FoodOrder();
            case "clothing" -> new ClothingOrder();
            // Add more cases for other order types.
            default -> throw new IllegalArgumentException("Invalid order type: " + orderType);
        };
    }
}