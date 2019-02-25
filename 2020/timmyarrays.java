
public class timmyarrays {

	private static int numRow1;
	private static int numRow2;
	private static int numCol1;
	private static int numCol2;
	private static int matrixMult[][];
	private static int tempFinal;

	public static int[][] mult(int[][] matrix1, int[][] matrix2) {
		numRow1 = matrix1.length;
		numRow2 = matrix2.length;
		numCol1 = matrix1[0].length;
		numCol2 = matrix2[0].length;
		matrixMult = new int [numRow1][numCol2];
		for (int r = 0; r < numRow1; r++) {
			for (int c = 0; c < numCol2; c++) {
				for (int i = 0; i < numRow2; i++) {
					matrixMult[r][c] += (matrix1[r][i] * matrix2[i][c]);
				}
			}
		}

		return matrixMult;
	}

	public static void print(int[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int tim = 0; tim < c[i].length; tim++) {
				System.out.print(c[i][tim] + " ");
			}
			System.out.println();
		}
	}

}
