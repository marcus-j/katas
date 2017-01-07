package de.marcusjanke.katas.fizzbuzz;

/**
 * 
 * @author marcus
 *
 */
public class FizzBuzz {

	/**
	 * 
	 * @param number
	 * @return 'fizz' if only divisible by 3, 'buzz' if only divisible by 5, 'fizzbuzz' if divisible 
	 * by both or the provided number in all other cases
	 */
    public static String getResult(final int number) {
    	StringBuilder sb = new StringBuilder();
    	if (number % 3 == 0) {
    		sb = sb.append("fizz");
    	} 
    	if (number % 5 == 0) {
    		sb = sb.append("buzz");
    	}
        if (sb.length() == 0) {
        	sb = sb.append(number);
        }
        return sb.toString();
    }
}