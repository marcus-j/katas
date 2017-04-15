package de.marcusjanke.katas.romannumerals;

/**
 * 
 * RomanNumeralToArabicNumeralFunction
 * 
 * @author marcus
 *
 */
public class RomanNumeralToArabicNumeralFunction extends AbstractRomanNumeralFunction<String, Integer> {

	/**
	 * convert a roman numeral string to an arabic integer
	 * 
	 * @param romanNumeral
	 * @return arabic integer
	 */
	@Override
	public Integer apply(String romanNumeral) {
		int arabicValue = 0;
		int previousArabicValue = 0;
		for (int i = romanNumeral.length() - 1; i >= 0; i--) {
			char currentRomanSymbol = romanNumeral.charAt(i);
			int currentArabicValue = getValueOfRomanSymbol(currentRomanSymbol);
			arabicValue += currentArabicValue < previousArabicValue ? -currentArabicValue : currentArabicValue;
			previousArabicValue = currentArabicValue;
		}
		return arabicValue;
	}
}
