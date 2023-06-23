public class TricycleFactory extends CycleFactory {
	
	@Override
    Cycle createCycle() {
        return new Tricycle();
    }

}
