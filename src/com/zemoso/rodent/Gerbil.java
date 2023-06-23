public class Gerbil extends Rodent {

	public Gerbil() {
        System.out.println("This is a Gerbil.");
    }

    @Override
    public void eat() {
        System.out.println("The Gerbil is eating seeds.");
    }

    @Override
    public void sleep() {
        System.out.println("The Gerbil is sleeping in a burrow.");
    }

    @Override
    public void run() {
        System.out.println("The Gerbil is darting across the room.");
    }
}
