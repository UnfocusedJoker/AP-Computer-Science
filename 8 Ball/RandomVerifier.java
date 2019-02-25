
import java.util.Random;

public class RandomVerifier {

	public static void main(String[] args) {
		Random rd = new Random();
		int boop[] = new int[10], hBoop = 0, lBoop = 0, bop;
		for (int i = 0; i < 1000000; i++) {
			boop[rd.nextInt(10)]++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("Number of " + i + "'s: " + boop[i]);
		}
		for (int i = 1; i < 10; i++) {
			if (boop[i] > boop[hBoop]) {
				hBoop = i;
			}
			if (boop[i] < boop[lBoop]) {
				lBoop = i;
			}
		}
		System.out.println("The most common index is " + hBoop);
		System.out.println("The least common index is " + lBoop);
		System.out.println("The range is " + (boop[hBoop] - boop[lBoop]));
	}

}
