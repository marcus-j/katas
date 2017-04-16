package de.marcusjanke.katas.happynumbers;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Show case test
 */
public class ShowCaseTest {

	private final Logger logger = LoggerFactory.getLogger(ShowCaseTest.class);

	/**
	 * Identify all happy numbers between 1 and 20
	 */
	@Test
	public void testShowCase() {
		for (int i = 1; i <= 20; i++) {
			if (HappyNumberRecognizer.isHappyNumber(i)) {
				logger.info(String.format("Happy number found: %s", i));
			}
		}
	}
}
