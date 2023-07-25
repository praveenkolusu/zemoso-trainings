package factory;
public class Main {
    public static void main(String[] args) {
        // Create an OnlineOrderProcessingFactory with the FoodOrderFactory
        OnlineOrderProcessingFactory foodOrderProcessingFactory = new OnlineOrderProcessingFactory(new FoodOrderFactory());
        Order foodOrder = foodOrderProcessingFactory.processOrder();
        foodOrder.processOrder();

        // Create an OnlineOrderProcessingFactory with the ClothingOrderFactory
        OnlineOrderProcessingFactory clothingOrderProcessingFactory = new OnlineOrderProcessingFactory(new ClothingOrderFactory());
        Order clothingOrder = clothingOrderProcessingFactory.processOrder();
        clothingOrder.processOrder();

        // Create an OnlineOrderProcessingFactory with a new factory for ElectronicsOrder (without modifying the factory or main method)
        OnlineOrderProcessingFactory electronicsOrderProcessingFactory = new OnlineOrderProcessingFactory(new ElectronicsOrderFactory());
        Order electronicsOrder = electronicsOrderProcessingFactory.processOrder();
        electronicsOrder.processOrder();
    }
}