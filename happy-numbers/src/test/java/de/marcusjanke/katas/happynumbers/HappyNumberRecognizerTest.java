package de.marcusjanke.katas.happynumbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for HappyNumberRecognizer
 */
public class HappyNumberRecognizerTest {

	/**
	 * Test valid happy numbers
	 */
	@Test
	public void testHappyNumberTrue() {
		Assert.assertTrue(HappyNumberRecognizer.isHappyNumber(1));
		Assert.assertTrue(HappyNumberRecognizer.isHappyNumber(7));
		Assert.assertTrue(HappyNumberRecognizer.isHappyNumber(10));
		Assert.assertTrue(HappyNumberRecognizer.isHappyNumber(13));
		Assert.assertTrue(HappyNumberRecognizer.isHappyNumber(19));
	}

	/**
	 * Test invalid happy numbers
	 */
	@Test
	public void testHappyNumberFalse() {
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(0));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(2));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(3));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(4));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(5));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(6));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(8));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(9));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(11));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(12));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(14));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(15));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(16));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(17));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(18));
		Assert.assertFalse(HappyNumberRecognizer.isHappyNumber(20));
	}
}
