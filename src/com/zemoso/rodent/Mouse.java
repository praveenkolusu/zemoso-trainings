public class Mouse extends Rodent {

	public Mouse() {
        System.out.println("This is a Mouse.");
    }

    @Override
    public void eat() {
        System.out.println("The Mouse is eating sugar.");
    }

    @Override
    public void sleep() {
        System.out.println("The Mouse is sleeping in a hole.");
    }

    @Override
    public void run() {
        System.out.println("The Mouse is scurrying around.");
    }
}