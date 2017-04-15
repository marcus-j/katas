package de.marcusjanke.katas.csvtotable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

/**
 * utility that formats data to fit in table
 * 
 * @author marcus
 *
 */
public class TableFormatUtil {

	private TableFormatUtil() {
	}

	/**
	 * format a row with the given values and paddings
	 * 
	 * @param values
	 * @param paddings
	 * @return formatted row
	 */
	public static String formatRow(List<String> values, List<Integer> paddings) {
		return IntStream.range(0, values.size()).sequential()
				.mapToObj(i -> StringUtils.rightPad(values.get(i), paddings.get(i))).collect(Collectors.joining("|"));
	}

	/**
	 * format a separator row with the given paddings
	 * 
	 * @param paddings
	 * @return formatted row
	 */
	public static String formatSeparatorRow(List<Integer> paddings) {
		return paddings.stream().map(padding -> StringUtils.rightPad("", padding, "-"))
				.collect(Collectors.joining("+"));
	}
}
