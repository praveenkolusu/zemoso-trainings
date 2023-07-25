package factory;

class ClothingOrder implements Order {
    @Override
    public String processOrder() {
        return  "Processing Clothing Order...";
        // Add specific logic to process a clothing order.
    }
}