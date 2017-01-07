package de.marcusjanke.katas.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author marcus
 *
 */
public class FizzBuzzTest {

	/**
	 * Tests that 'fizz' is returned if only divisible by 3
	 */
	@Test
	public void getResultShouldReturnFizzIfOnlyDivisableBy3() {
		Assert.assertEquals("fizz", FizzBuzz.getResult(3));
		Assert.assertEquals("fizz", FizzBuzz.getResult(6));
		Assert.assertEquals("fizz", FizzBuzz.getResult(9));
	}

	/**
	 * Tests that 'fizz' is returned if only divisible by 5
	 */
	@Test
	public void getResultShouldReturnBuzzIfOnlyDivisableBy5() {
		Assert.assertEquals("buzz", FizzBuzz.getResult(5));
		Assert.assertEquals("buzz", FizzBuzz.getResult(10));
		Assert.assertEquals("buzz", FizzBuzz.getResult(20));
	}


	/**
	 * Tests that 'fizz' is returned if divisible by both 3 and 5
	 */
	@Test
	public void getResultShouldReturnBuzzIfDivisableBy15() {
		Assert.assertEquals("fizzbuzz", FizzBuzz.getResult(15));
		Assert.assertEquals("fizzbuzz", FizzBuzz.getResult(30));
		Assert.assertEquals("fizzbuzz", FizzBuzz.getResult(45));
	}

	/**
	 * Tests that original number is returned if not divisible by either 3 or 5
	 */
	@Test
	public void getResultShouldReturnTheSameNumberIfNotDivisibleByEither3or5() {
		Assert.assertEquals("1", FizzBuzz.getResult(1));
		Assert.assertEquals("2", FizzBuzz.getResult(2));
		Assert.assertEquals("4", FizzBuzz.getResult(4));
	}

}