public class Main {

	public static void methodA(Interface1 obj) {
        
    }

    public static void methodB(Interface2 obj) {
        
    }

    public static void methodC(Interface3 obj) {
        
    }

    public static void methodD(CombinedInterface obj) {
        
    }

	public static void main(String[] args) {
		MyClass myObject = new MyClass();
        methodA(myObject);
        methodB(myObject);
        methodC(myObject);
        methodD(myObject);
	}
}
