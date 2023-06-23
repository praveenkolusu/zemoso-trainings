public class Main {

	public static void methodA(Vehicle obj) {
        
    }

    public static void methodB(Rodent obj) {
        
    }

    public static void methodC(Thing obj) {
        
    }

    public static void methodD(CombinedInterface obj) {
        
    }

	public static void main(String[] args) {
		MyClass myObject = new MyClass();
        System.out.println("Interface default method value: " + myObject.getInt());
        methodA(myObject);
        methodB(myObject);
        methodC(myObject);
        methodD(myObject);
	}
}
