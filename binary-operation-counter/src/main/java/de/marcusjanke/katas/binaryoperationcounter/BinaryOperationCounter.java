package de.marcusjanke.katas.binaryoperationcounter;

import static java.lang.String.format;

public class BinaryOperationCounter {

	private static final String ONE = "1";
	private static final String ZERO = "0";
	private static final String BINARY_REGEX = "[0-1]+";

	public long countOperations(String binary) {
		assertBinary(binary);
		return performOperation(trim(binary));
	}

	private long performOperation(String original) {
		String working = original;
		long counter = 0L;
		while (!ZERO.equals(original)) {
			counter++;
			if (isOdd(original)) {
				working = substractOne(working);
			} else {
				working = trim(divideByTwo(working));
			}
		}
		return counter;
	}

	private String divideByTwo(String original) {
		String result;
		if (original.contains(ONE)) {
			if (original.startsWith(ONE)) {
				result = ZERO + divideByTwo(original.substring(1));
			} else {
				result = ONE + original.substring(1);
			}
		} else {
			result = "0";
		}
		return result;
	}

	private String substractOne(String original) {
		return original.substring(0, original.length() - 2) + ZERO;
	}

	private boolean isOdd(String original) {
		return original.endsWith(ONE);
	}

	private String trim(String binary) {
		String trimmed = ZERO;
		if (binary.contains(ONE)) {
			trimmed = binary.substring(binary.indexOf(ONE));
		}
		return trimmed;
	}

	private void assertBinary(String binary) {
		if (!binary.matches(BINARY_REGEX)) {
			throw new IllegalArgumentException(format("Not a binary string representation, does not match %s", BINARY_REGEX));
		}
	}
}
