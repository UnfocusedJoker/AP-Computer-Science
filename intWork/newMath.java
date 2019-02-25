
public class newMath implements interMath {
	public double mod(double x, double y) {
		if (y > x) {
			return 0;
		}
		int i = (int) (x / y);
		double d = (x / y) - i;
		return d * y;
	}

	public double pow(double x, int y) {
		double num = x;
		if (y == 0) {
			return 1.0;
		}
		for (int i = 0; i < y - 1; i++) {
			num *= x;
		}
		return num;
	}

	public double div(double x, double y) {
		return x / y;
	}

	public double doubleDiv(double x, double y) {
		return (x / y) / y;
	}

	public double tripleDiv(double x, double y) {
		return ((x / y) / y) / y;
	}

	public double mult(double x, double y) {
		return x * y;
	}

	public double negafy(double x) {
		if (x > 0) {
			return x * -1;
		}
		return x;
	}
}
