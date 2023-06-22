public class Hamster extends Rodent {
	
	public Hamster() {
        System.out.println("This is a Hamster.");
    }

    @Override
    public void eat() {
        System.out.println("The Hamster is munching on food pellets.");
    }

    @Override
    public void sleep() {
        System.out.println("The Hamster is curled up in its nest.");
    }
    
    @Override
    public void run() {
        System.out.println("The Hamster is running on its wheel.");
    }

}