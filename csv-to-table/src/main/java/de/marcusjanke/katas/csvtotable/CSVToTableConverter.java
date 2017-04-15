package de.marcusjanke.katas.csvtotable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This a sample solution for the function kata "CSV to table"
 * 
 * @author marcus
 *
 */
public class CSVToTableConverter {

	private final String separator;

	/**
	 * Create a CSVToTableConverter instance using the specified value separator
	 * 
	 * @param separator
	 */
	public CSVToTableConverter(String separator) {
		super();
		this.separator = separator;
	}

	/**
	 * converts CSV lines. Values are assumed to be separated by ";". The first
	 * row is assumed to represent table headers. Rows are assumed to contain
	 * the same amount of columns.
	 * 
	 * @param csvLines
	 * @return CSV formated table lines
	 */
	public List<String> convertToTable(List<String> csvLines) {
		List<String> formattedLines = new ArrayList<>();
		List<Integer> globalColumnLengths = getGlobalPaddings(csvLines);
		formattedLines
				.add(TableFormatUtil.formatRow(Arrays.asList(csvLines.get(0).split(separator)), globalColumnLengths));
		formattedLines.add(TableFormatUtil.formatSeparatorRow(globalColumnLengths));
		IntStream.range(1, csvLines.size()).forEach(i -> formattedLines
				.add(TableFormatUtil.formatRow(Arrays.asList(csvLines.get(i).split(separator)), globalColumnLengths)));
		return formattedLines;
	}

	/**
	 * get paddings of row elements
	 * 
	 * @param line
	 * @return list of paddings
	 */
	private List<Integer> getColumnsPaddingsForLine(String line) {
		return Stream.of(line.split(separator)).mapToInt(value -> value.length()).boxed().collect(Collectors.toList());
	}

	/**
	 * compare all row paddings return list of global maximum paddings
	 * 
	 * @param csvLines
	 * @return global maximum paddings
	 */
	private List<Integer> getGlobalPaddings(List<String> csvLines) {
		return csvLines.stream().map(this::getColumnsPaddingsForLine).reduce(this::getMaxPaddingsOfTwoRows).get();
	}

	/**
	 * compare paddings of two rows and return list of maximum paddings
	 * 
	 * @param first
	 *            row
	 * @param second
	 *            row
	 * @return list of maximum paddings of both rows
	 */
	private List<Integer> getMaxPaddingsOfTwoRows(List<Integer> a, List<Integer> b) {
		return IntStream.range(0, a.size()).map(i -> Math.max(a.get(i), b.get(i))).boxed().collect(Collectors.toList());
	}
}
