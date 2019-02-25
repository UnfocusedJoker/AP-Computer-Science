
public class bigDs {

	public static void print1D(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

	public static void print1D(String[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

	public static void print2D(int[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int k = 0; k < x[i].length; k++) {
				System.out.print(x[i][k] + " ");
			}
			System.out.println();
		}
	}

	public static void print2D(String[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int k = 0; k < x[i].length; k++) {
				System.out.print(x[i][k] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] compileArrays(int[] x, int[] y, int[] z) {
		int bigBoi[][] = new int[3][];
		bigBoi[0] = x;
		bigBoi[1] = y;
		bigBoi[2] = z;
		return bigBoi;
	}

	public static String[][] evenArray(String[][] words) {
		int sLen = words[0].length;
		for (int i = 1; i < words.length; i++) {
			if (words[i].length < sLen) {
				sLen = words[i].length;
			}
		}
		String[][] wordsE = new String[words.length][sLen];
		for (int i = 0; i < words.length; i++) {
			for (int k = 0; k < sLen; k++) {
				wordsE[i][k] = words[i][k];
			}
		}
		return wordsE;
	}

	public static boolean stringLength(int[] lens, String[][] words) {
		boolean boop = true;
		for (int i = 0; i < words.length; i++) {
			for (int k = 0; k < words[i].length; k++) {
				if (words[i][k].length() != lens[k]) {
					boop = false;
				}
			}
		}
		return boop;
	}

	public static int[] thirdCol(int[][] nums) {
		int[] nums2 = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i][2];
		}
		return nums2;
	}

	public static boolean dupes(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (int k = 0; k < words.length; k++) {
				if (words[i].equals(words[k]) && !(i == k)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean multiDupes(String[][] words) {
		for(int i = 0; i < words.length; i++) {
			for(int k = 0; k < words[i].length; k++) {
				for(int j = 0; j < words.length; j++) {
					for(int b = 0; b < words[j].length; b++) {
						if(words[i][k].equals(words[j][b]) && !(i == j && k == b)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static int[][] noEvens(int[][] nums) {
		int[][] numsD = new int[nums.length][];
		for (int i = 0; i < nums.length; i++) {
			numsD[i] = new int[nums[i].length];
		}
		for (int i = 0; i < nums.length; i++) {
			for (int k = 0; k < nums[i].length; k++) {
				if (nums[i][k] % 2 == 0) {
					numsD[i][k] = 5;
				} else {
					numsD[i][k] = nums[i][k];
				}
			}
		}
		return numsD;
	}

}
