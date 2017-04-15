package de.marcusjanke.katas.romannumerals;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Abstract utillity function. May be used for various roman numeral operations
 * 
 * @author marcus
 *
 * @param <T>
 *            functional input
 * @param <R>
 *            functional output
 */
public abstract class AbstractRomanNumeralFunction<T, R> implements Function<T, R> {

	public abstract R apply(T t);

	private static final Map<Character, Integer> symbolValueMap = new HashMap<>();
	static {
		symbolValueMap.put('I', 1);
		symbolValueMap.put('V', 5);
		symbolValueMap.put('X', 10);
		symbolValueMap.put('L', 50);
		symbolValueMap.put('C', 100);
		symbolValueMap.put('D', 500);
		symbolValueMap.put('M', 1000);
	}

	/**
	 * get arabic value of roman symbol
	 * 
	 * @param symbol
	 * @return arabic value
	 */
	Integer getValueOfRomanSymbol(Character symbol) {
		return symbolValueMap.get(symbol);
	}
}
