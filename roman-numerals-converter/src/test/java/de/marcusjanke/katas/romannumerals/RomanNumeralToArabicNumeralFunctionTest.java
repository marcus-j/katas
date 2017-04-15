package de.marcusjanke.katas.romannumerals;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Unit test for RomanNumeralToArabicNumeralFunction.
 * 
 * @author marcus
 *
 */
public class RomanNumeralToArabicNumeralFunctionTest {

	private final RomanNumeralToArabicNumeralFunction romanNumeralToArabicNumeralFunction = new RomanNumeralToArabicNumeralFunction();

	/**
	 * Unit test for RomanNumeralToArabicNumeralFunction.
	 */
	@Test
	public void testRomanNumeralToArabicNumeralFunction() {
		Assert.assertEquals(Integer.valueOf(1), romanNumeralToArabicNumeralFunction.apply("I"));
		Assert.assertEquals(Integer.valueOf(2), romanNumeralToArabicNumeralFunction.apply("II"));
		Assert.assertEquals(Integer.valueOf(3), romanNumeralToArabicNumeralFunction.apply("III"));
		Assert.assertEquals(Integer.valueOf(4), romanNumeralToArabicNumeralFunction.apply("IV"));
		Assert.assertEquals(Integer.valueOf(5), romanNumeralToArabicNumeralFunction.apply("V"));
		Assert.assertEquals(Integer.valueOf(6), romanNumeralToArabicNumeralFunction.apply("VI"));
		Assert.assertEquals(Integer.valueOf(7), romanNumeralToArabicNumeralFunction.apply("VII"));
		Assert.assertEquals(Integer.valueOf(8), romanNumeralToArabicNumeralFunction.apply("VIII"));
		Assert.assertEquals(Integer.valueOf(9), romanNumeralToArabicNumeralFunction.apply("IX"));
		Assert.assertEquals(Integer.valueOf(10), romanNumeralToArabicNumeralFunction.apply("X"));
		Assert.assertEquals(Integer.valueOf(11), romanNumeralToArabicNumeralFunction.apply("XI"));
		Assert.assertEquals(Integer.valueOf(12), romanNumeralToArabicNumeralFunction.apply("XII"));
		Assert.assertEquals(Integer.valueOf(13), romanNumeralToArabicNumeralFunction.apply("XIII"));
		Assert.assertEquals(Integer.valueOf(14), romanNumeralToArabicNumeralFunction.apply("XIV"));
		Assert.assertEquals(Integer.valueOf(15), romanNumeralToArabicNumeralFunction.apply("XV"));
		Assert.assertEquals(Integer.valueOf(16), romanNumeralToArabicNumeralFunction.apply("XVI"));
		Assert.assertEquals(Integer.valueOf(17), romanNumeralToArabicNumeralFunction.apply("XVII"));
		Assert.assertEquals(Integer.valueOf(18), romanNumeralToArabicNumeralFunction.apply("XVIII"));
		Assert.assertEquals(Integer.valueOf(19), romanNumeralToArabicNumeralFunction.apply("XIX"));
		Assert.assertEquals(Integer.valueOf(20), romanNumeralToArabicNumeralFunction.apply("XX"));
		Assert.assertEquals(Integer.valueOf(2000), romanNumeralToArabicNumeralFunction.apply("MM"));
		Assert.assertEquals(Integer.valueOf(1551), romanNumeralToArabicNumeralFunction.apply("MDLI"));
		Assert.assertEquals(Integer.valueOf(2017), romanNumeralToArabicNumeralFunction.apply("MMXVII"));
	}
}
