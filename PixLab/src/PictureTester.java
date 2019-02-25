/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	public static void convertToBlackAndWhite() {
		int x = 0;
		Picture pic = new Picture("femaleLionAndHall.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				x = (int) pixels[row][col].getAverage();
				pixels[row][col].setBlue(x);
				pixels[row][col].setGreen(x);
				pixels[row][col].setRed(x);
			}
		}
		pic.explore();
	}

	public static void adjustBrightness(double brightL) {
		Picture pic = new Picture("koala.jpg");
		int highVal;
		double edit;
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				edit = brightL;
				highVal = pixels[row][col].getGreen();
				if ((pixels[row][col].getBlue() > pixels[row][col].getRed())
						&& (pixels[row][col].getBlue() > pixels[row][col].getGreen())) {
					highVal = pixels[row][col].getBlue();
				} else if ((pixels[row][col].getRed() > pixels[row][col].getBlue())
						&& (pixels[row][col].getRed() > pixels[row][col].getGreen())) {
					highVal = pixels[row][col].getRed();
				}
				if (highVal * brightL > 255) {
					System.out.println(highVal);
					edit = 255.0 / highVal;
				}
				pixels[row][col].setRed((int) (pixels[row][col].getRed() * edit));
				pixels[row][col].setGreen((int) (pixels[row][col].getGreen() * edit));
				pixels[row][col].setBlue((int) (pixels[row][col].getBlue() * edit));
			}
		}
		pic.explore();
	}

	public static void verticalMirror() {
		Picture pic = new Picture("redMotorcycle.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for (int col1 = 0, col2 = pixels[0].length - 1; col1 < pixels[0].length / 2; col1++, col2--) {
				pixels[row][col2].setRed(pixels[row][col1].getRed());
				pixels[row][col2].setGreen(pixels[row][col1].getGreen());
				pixels[row][col2].setBlue(pixels[row][col1].getBlue());
			}
		}
		pic.explore();
	}

	public static void horizontalMirror() {
		Picture pic = new Picture("redMotorcycle.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		for (int col = 0; col < pixels[0].length; col++) {
			for (int row1 = 0, row2 = pixels.length - 1; row1 < pixels.length / 2; row1++, row2--) {
				pixels[row2][col].setRed(pixels[row1][col].getRed());
				pixels[row2][col].setGreen(pixels[row1][col].getGreen());
				pixels[row2][col].setBlue(pixels[row1][col].getBlue());
			}
		}
		pic.explore();
	}

	public static void sDiagonalMirror() {
		Picture pic = new Picture("redMotorcycle.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		if (pixels.length > pixels[0].length) {
			for (int row = 0; row < pixels.length; row++) {
				for (int col = 0; col < row; col++) {
					pixels[col][row].setRed(pixels[row][col].getRed());
					pixels[col][row].setGreen(pixels[row][col].getGreen());
					pixels[col][row].setBlue(pixels[row][col].getBlue());
				}
			}
		} else {
			for (int row = 0; row < pixels.length; row++) {
				for (int col = 0; col < row; col++) {
					pixels[row][col].setRed(pixels[col][row].getRed());
					pixels[row][col].setGreen(pixels[col][row].getGreen());
					pixels[row][col].setBlue(pixels[col][row].getBlue());
				}
			}
		}
		pic.explore();
	}

	public static void aDiagonalMirror() {
		Picture pic = new Picture("butterfly1.jpg");
		pic.explore();
		Pixel[][] pixels = pic.getPixels2D();
		if (pixels.length > pixels[0].length) { // portrait
			System.out.print(1);
			for (double col = 0, y = 0; col < pixels[0].length; col++, y = y
					+ ((1.0 * pixels.length) / (pixels[0].length))) {
				for (int row = (int) Math.round(y), count = (int) col; count >= 0; row--, count--) {
					pixels[row][(int) col].setRed(pixels[(int) Math.round(y)][count].getRed());
					pixels[row][(int) col].setGreen(pixels[(int) Math.round(y)][count].getGreen());
					pixels[row][(int) col].setBlue(pixels[(int) Math.round(y)][count].getBlue());
				}
			}
		} else { // square or landscape
			System.out.print(2);
			for (double col = 0, y = 0; col < pixels[0].length; col++, y = y
					+ ((1.0 * pixels.length) / (pixels[0].length))) {
				for (int row = (int) Math.round(y), count = (int) col; row >= 0; row--, count--) {
					pixels[row][(int) col].setRed(pixels[(int) Math.round(y)][count].getRed());
					pixels[row][(int) col].setGreen(pixels[(int) Math.round(y)][count].getGreen());
					pixels[row][(int) col].setBlue(pixels[(int) Math.round(y)][count].getBlue());
				}
			}
		}
		pic.explore();
	}
	
	public static void repairTemple() {
		Picture pic1 = new Picture("temple.jpg");
		Picture pic2 = new Picture("temple.jpg");
		pic1.explore();
		Pixel[][] pixels1 = pic1.getPixels2D();
		Pixel[][] pixels2 = pic2.getPixels2D();
		for (int row = 27; row < 96; row++) {
			for (int col1 = 13, col2 = 276 + 262; col1 < 276; col1++, col2--) {
				pixels2[row][col2].setRed(pixels1[row][col1].getRed());
				pixels2[row][col2].setGreen(pixels1[row][col1].getGreen());
				pixels2[row][col2].setBlue(pixels1[row][col1].getBlue());
			}
		}
		pic2.explore();
	}

	public static void flipHorizontal() {
		Picture pic1 = new Picture("butterfly1.jpg");
		Picture pic2 = new Picture("butterfly1.jpg");
		pic1.explore();
		Pixel[][] pixels1 = pic1.getPixels2D();
		Pixel[][] pixels2 = pic2.getPixels2D();
		for (int row = 0; row < pixels1.length; row++) {
			for (int col1 = 0, col2 = pixels1[0].length - 1; col1 < pixels1[0].length; col1++, col2--) {
				pixels2[row][col2].setRed(pixels1[row][col1].getRed());
				pixels2[row][col2].setGreen(pixels1[row][col1].getGreen());
				pixels2[row][col2].setBlue(pixels1[row][col1].getBlue());
			}
		}
		pic2.explore();
	}

	public static void flipVertical() {
		Picture pic1 = new Picture("butterfly1.jpg");
		Picture pic2 = new Picture("butterfly1.jpg");
		pic1.explore();
		Pixel[][] pixels1 = pic1.getPixels2D(), pixels2 = pic2.getPixels2D();
		for (int col = 0; col < pixels1[0].length; col++) {
			for (int row1 = 0, row2 = pixels1.length - 1; row1 < pixels1.length; row1++, row2--) {
				pixels2[row2][col].setRed(pixels1[row1][col].getRed());
				pixels2[row2][col].setGreen(pixels1[row1][col].getGreen());
				pixels2[row2][col].setBlue(pixels1[row1][col].getBlue());
			}
		}
		pic2.explore();
	}

	public static void testZeroRed() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroRed();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		// testZeroBlue();
		// testZeroRed();
		// convertToBlackAndWhite();
		// adjustBrightness(6);
		// verticalMirror();
		// horizontalMirror();
		// sDiagonalMirror();
		// aDiagonalMirror();
		// flipHorizontal();
		// flipVertical();
		// repairTemple();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorVertical();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		testCollage();
		// testCopy();
		// testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
	}
}