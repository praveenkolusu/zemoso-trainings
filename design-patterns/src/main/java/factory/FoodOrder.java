package factory;

class FoodOrder implements Order {
    @Override
    public String processOrder() {
        return "Processing Food Order...";
        // Add specific logic to process a food order.
    }
}