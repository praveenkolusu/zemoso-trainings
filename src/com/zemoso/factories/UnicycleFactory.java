public class UnicycleFactory extends CycleFactory {
	
	@Override
    Cycle createCycle() {
        return new Unicycle();
    }
}
