package de.marcusjanke.katas.romannumerals;

/**
 * 
 * RomanNumeralsConverter
 * 
 * @author marcus
 *
 */
public class RomanNumeralsConverter {

	private final RomanNumeralToArabicNumeralFunction romanNumeralToArabicNumeralFunction = new RomanNumeralToArabicNumeralFunction();

	/**
	 * convert a roman numeral string to an arabic integer
	 * 
	 * @param romanNumeral
	 * @return arabic integer
	 */
	public Integer convertToArabicInteger(String romanNumeral) {
		return romanNumeralToArabicNumeralFunction.apply(romanNumeral);
	}
}
