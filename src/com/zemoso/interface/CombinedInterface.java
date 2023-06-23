public interface CombinedInterface extends Vehicle, Rodent, Thing {
	void newMethod();

	default int getInt() {
		return 1;
	}
}
