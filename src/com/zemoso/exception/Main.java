public class Main {

	public static void main(String[] args) {
		
		ExceptionDemo demo = new ExceptionDemo();

        try {
            demo.throwExceptions();
        } catch (Exception1 | Exception2 | Exception3 e) {
            System.out.println("Caught exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Finally block executed.");
        }
	}
}