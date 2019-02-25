import java.util.Scanner;

public class MagpieRunner {

	public static void main(String[] args) {
		Magpie4 maggie = new Magpie4();

		System.out.println(maggie.getGreeting());
		Scanner in = new Scanner(System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye")) {
			maggie.router(statement);
			statement = in.nextLine();
		}
	}
}
