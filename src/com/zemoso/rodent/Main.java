public class Main {

	public static void main(String[] args) {

		Rodent[] rodents = new Rodent[3];

        rodents[0] = new Mouse();
        rodents[1] = new Gerbil();
        rodents[2] = new Hamster();

        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
            rodent.run();
            System.out.println();
        }
	}
}