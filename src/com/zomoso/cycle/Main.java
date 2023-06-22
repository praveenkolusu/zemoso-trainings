package com.zomoso.cycle;

public class Main {

	public static void main(String[] args) {
		
		Cycle[] cycles = new Cycle[3];
        cycles[0] = new Unicycle();
        cycles[1] = new Bicycle();
        cycles[2] = new Tricycle();
        // Upcasting
        for (Cycle cycle : cycles) {
            cycle.balance();
        }
       // Downcasting
        for (Cycle cycle : cycles) {
            if (cycle instanceof Unicycle) {
                Unicycle unicycle = (Unicycle) cycle;
                unicycle.balance(); 
            } else if (cycle instanceof Bicycle) {
                Bicycle bicycle = (Bicycle) cycle;
                bicycle.balance();  
            } else if (cycle instanceof Tricycle) {
                Tricycle tricycle = (Tricycle) cycle;
                tricycle.balance();  
            }
        }
	}
}