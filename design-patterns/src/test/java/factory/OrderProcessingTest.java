package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderProcessingTest {

    @Test
    public void testFoodOrderProcessing() {
        OrderFactory foodOrderFactory = new FoodOrderFactory();
        Order foodOrder = foodOrderFactory.createOrder();

        assertTrue(foodOrder instanceof FoodOrder);
        assertEquals("Processing Food Order...", foodOrder.processOrder());
    }

    @Test
    public void testClothingOrderProcessing() {
        OrderFactory clothingOrderFactory = new ClothingOrderFactory();
        Order clothingOrder = clothingOrderFactory.createOrder();

        assertTrue(clothingOrder instanceof ClothingOrder);
        assertEquals("Processing Clothing Order...", clothingOrder.processOrder());
    }
}
