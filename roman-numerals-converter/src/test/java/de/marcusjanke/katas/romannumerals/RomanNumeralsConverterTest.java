package de.marcusjanke.katas.romannumerals;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Unit test for RomanNumeralsConverter.
 * 
 * @author marcus
 *
 */
public class RomanNumeralsConverterTest {

	private final RomanNumeralsConverter converter = new RomanNumeralsConverter();

	/**
	 * Unit test for RomanNumeralsConverter.
	 */
	@Test
	public void testRomanNumeralToArabicNumeralFunction() {
		Assert.assertEquals(Integer.valueOf(1), converter.convertToArabicInteger("I"));
		Assert.assertEquals(Integer.valueOf(2), converter.convertToArabicInteger("II"));
		Assert.assertEquals(Integer.valueOf(3), converter.convertToArabicInteger("III"));
		Assert.assertEquals(Integer.valueOf(4), converter.convertToArabicInteger("IV"));
		Assert.assertEquals(Integer.valueOf(5), converter.convertToArabicInteger("V"));
		Assert.assertEquals(Integer.valueOf(6), converter.convertToArabicInteger("VI"));
		Assert.assertEquals(Integer.valueOf(7), converter.convertToArabicInteger("VII"));
		Assert.assertEquals(Integer.valueOf(8), converter.convertToArabicInteger("VIII"));
		Assert.assertEquals(Integer.valueOf(9), converter.convertToArabicInteger("IX"));
		Assert.assertEquals(Integer.valueOf(10), converter.convertToArabicInteger("X"));
		Assert.assertEquals(Integer.valueOf(11), converter.convertToArabicInteger("XI"));
		Assert.assertEquals(Integer.valueOf(12), converter.convertToArabicInteger("XII"));
		Assert.assertEquals(Integer.valueOf(13), converter.convertToArabicInteger("XIII"));
		Assert.assertEquals(Integer.valueOf(14), converter.convertToArabicInteger("XIV"));
		Assert.assertEquals(Integer.valueOf(15), converter.convertToArabicInteger("XV"));
		Assert.assertEquals(Integer.valueOf(16), converter.convertToArabicInteger("XVI"));
		Assert.assertEquals(Integer.valueOf(17), converter.convertToArabicInteger("XVII"));
		Assert.assertEquals(Integer.valueOf(18), converter.convertToArabicInteger("XVIII"));
		Assert.assertEquals(Integer.valueOf(19), converter.convertToArabicInteger("XIX"));
		Assert.assertEquals(Integer.valueOf(20), converter.convertToArabicInteger("XX"));
		Assert.assertEquals(Integer.valueOf(2000), converter.convertToArabicInteger("MM"));
		Assert.assertEquals(Integer.valueOf(1551), converter.convertToArabicInteger("MDLI"));
		Assert.assertEquals(Integer.valueOf(2017), converter.convertToArabicInteger("MMXVII"));
	}
}
