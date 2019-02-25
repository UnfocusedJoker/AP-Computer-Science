
import java.util.Random;
import java.util.Scanner;

public class ball8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello, I am the Magic 8 Ball! Would you like to ask a question?");
		String user = scan.nextLine();
		if (user.equalsIgnoreCase("yes")) {
			while (true) {
				System.out.println("What would you like to ask?");
				user = scan.nextLine();
				randChoice();
			}
		} else {
			System.out.println("Scum!");
		}
	}
	
	public static void randChoice() {
		Random rand = new Random();
		int randInt = rand.nextInt(10);
		if (randInt == 0) {
			System.out.println("Sure!");
		} else if (randInt == 1) {
			System.out.println("Yah bro!");
		} else if (randInt == 2) {
			System.out.println("Of course!");
		} else if (randInt == 3) {
			System.out.println("Perhaps...");
		} else if (randInt == 4) {
			System.out.println("Maybe...");
		} else if (randInt == 5) {
			System.out.println("I'm not quite sure...");
		} else if (randInt == 6) {
			System.out.println("Nah bro!");
		} else if (randInt == 7) {
			System.out.println("I don't think so!");
		} else if (randInt == 8) {
			System.out.println("Not really.");
		} else if (randInt == 9) {
			System.out.println("That's something I would never answer.");
		} 

	}

}
