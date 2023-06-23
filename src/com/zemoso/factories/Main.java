public class Main {
	
	public static void main(String[] args) {
        CycleFactory cycleFactory = new CycleFactory();
        Cycle bicycle = cycleFactory.createCycle();
        bicycle.ride();

        CycleFactory unicycleFactory = new UnicycleFactory();
        Cycle unicycle = unicycleFactory.createCycle();
        unicycle.ride();

        CycleFactory tricycleFactory = new TricycleFactory();
        Cycle tricycle = tricycleFactory.createCycle();
        tricycle.ride();
	}
}