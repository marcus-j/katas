package de.marcusjanke.katas.csvtotable;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.marcusjanke.katas.csvtotable.TableFormatUtil;

/**
 * TableFormatUtil tests
 */
public class TableFormatUtilTest {

	private final List<String> testValues = Arrays.asList("ABC", "123457", "10,000,00.00 USD");
	private final List<Integer> testPaddings = Arrays.asList(7, 10, 20);

	/**
	 * Test formatting of data row
	 */
	@Test
	public void testFormattedRow() {
		String formattedRow = TableFormatUtil.formatRow(testValues, testPaddings);
		assertFormattedRowLength(formattedRow, testPaddings);
		assertFormattedRowContent(formattedRow, testValues);
	}

	/**
	 * Test formatting of separator row
	 */
	@Test
	public void testFormattedSeparatorRow() {
		assertFormattedRowLength(TableFormatUtil.formatSeparatorRow(testPaddings), testPaddings);
	}

	/**
	 * assert content is contained in formatted row
	 * 
	 * @param formattedRow
	 * @param values
	 */
	private void assertFormattedRowContent(String formattedRow, List<String> values) {
		Assert.assertTrue(
				values.stream().map(value -> formattedRow.contains(value)).reduce((a, b) -> a && b).orElse(false));
	}

	/**
	 * assert formatted row has correct length
	 * 
	 * @param formattedRow
	 * @param paddings
	 */
	private void assertFormattedRowLength(String formattedRow, List<Integer> paddings) {
		Assert.assertEquals(paddings.stream().mapToInt(Integer::intValue).sum() + (paddings.size() - 1),
				formattedRow.length());
	}
}
