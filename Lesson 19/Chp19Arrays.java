
import java.util.Scanner;

public class Chp19Arrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student bruh = new Student("Jack", 2);
		System.out.println(bruh);
		Student[] classroom = new Student[5];
		for(int i = 0; i < classroom.length; i++) {
			System.out.println("Enter a student's name!");
			String name = scan.nextLine();
			System.out.println("Enter a student's age!");
			int age = scan.nextInt();
			scan.nextLine();
			classroom[i] = new Student(name, age);
		}
		System.out.println(classroom[2]);
		String[] arr5 = new String[5];
		for(int i = 0; i < 5; i++) {
			System.out.println("Please enter a name!");
			arr5[i] = scan.nextLine();
		}
		System.out.println("Names: ");
		for(int i = 0; i < 5; i++) {
			System.out.println(arr5[i]);
		}
	}

}
