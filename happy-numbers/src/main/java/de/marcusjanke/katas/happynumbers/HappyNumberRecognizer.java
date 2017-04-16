package de.marcusjanke.katas.happynumbers;

/**
 * HappyNumberRecognizer
 * 
 * @author marcus
 *
 */
public class HappyNumberRecognizer {
	
	private HappyNumberRecognizer() {
	}

	/**
	 * tests whether the provided number is a happy number
	 * @param number
	 * @return true if happy number
	 */
	public static boolean isHappyNumber(long number) {
		if (isExitCondition(number)) {
			return false;
		}
		if (number == 1) {
			return true;
		} 
		return isHappyNumber(sumOfSquares(number));
	}

	/**
	 * calculates the sum of squares of the digits of this number
	 * @param number
	 * @return sum of squares of the digits of this number
	 */
	private static long sumOfSquares(long number) {
		long sumOfSquares = 0;
		long currentDigit = 0;
		while (number > 0) {
			currentDigit = number % 10;
			sumOfSquares += currentDigit * currentDigit;
			number /= 10;
		}
		return sumOfSquares;
	}
	
	/**
	 * tests whether the exit condition (definitely not a happy number) is met.
	 * @param number
	 * @return true if definitely not a happy number
	 */
	private static boolean isExitCondition(long number) {
		return number == 0 || number == 4;
	}
}
