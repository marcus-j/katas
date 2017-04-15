package de.marcusjanke.katas.csvtotable;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.marcusjanke.katas.csvtotable.CSVToTableConverter;

/**
 * Show case test for this katas solution
 * 
 * @author marcus
 *
 */
public class CSVToTableConverterTest {

	private final CSVToTableConverter converter = new CSVToTableConverter(";");

	/**
	 * Test csv conversion
	 */
	@Test
	public void testConvertToTableLine() {
		List<String> csvLines = Arrays.asList("Name;Strasse;Ort;Alter", "Peter Pan;Am Hang 5;12345 Einsam;42",
				"Maria Schmitz;Kölner Straße 45;50123 Köln;43", "Paul Meier;Münchener Weg 1;87654 München;65");
		List<String> formattedLines = converter.convertToTable(csvLines);
		Assert.assertEquals("Line count should only increase by one.", csvLines.size() + 1, formattedLines.size());
		Assert.assertEquals("Line length should be identical", true, formattedLines.stream()
				.map(line -> line.length() == formattedLines.get(0).length()).reduce((a, b) -> a && b).orElse(false));
	}

	/**
	 * Show example formatting
	 */
	@Test
	public void showCase() {
		List<String> csvLines = Arrays.asList("Name;Strasse;Ort;Alter", "Peter Pan;Am Hang 5;12345 Einsam;42",
				"Maria Schmitz;Kölner Straße 45;50123 Köln;43", "Paul Meier;Münchener Weg 1;87654 München;65");
		converter.convertToTable(csvLines).forEach(System.out::println);
	}
}
