

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CoolMethods.timmy(scan.nextLine());
		scan.nextLine();
		System.out.print("Enter the A value for the line: ");
		DistToLine.A = scan.nextDouble();
		System.out.print("Enter the B value for the line: ");
		DistToLine.B = scan.nextDouble();
		System.out.print("Enter the C value for the line: ");
		DistToLine.C = scan.nextDouble();
		System.out.print("Enter the x coordinate of the point: ");
		double a = scan.nextDouble();
		System.out.print("Enter the y coordinate of the point: ");
		double b = scan.nextDouble();
		System.out.print("Distance from the point to the line is: " + DistToLine.getDist(a, b));
		scan.close();
	}

}
