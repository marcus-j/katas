package de.marcusjanke.katas.maxstack;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Tests for MaxStack
 * 
 * @author marcus
 *
 */
public class MaxStackTest {

	/**
	 * test push and pop
	 */
	@Test
	public void testPushAndPop() {
		MaxStack<Integer> stack = new MaxStack<>();
		assertThat(stack.size()).isZero();
		assertThat(stack.max()).isEmpty();

		stack.push(5);
		assertThat(stack.size()).isEqualTo(1);
		assertThat(stack.max()).isNotEmpty().hasValue(5);
		assertThat(stack.pop()).isNotEmpty().hasValue(5);

		assertThat(stack.size()).isZero();
		assertThat(stack.max()).isEmpty();
		assertThat(stack.pop()).isEmpty();
	}

	/**
	 * test push and pop of multiple values and changing maxes
	 */
	@Test
	public void testMultiPushAndPop() {
		MaxStack<Integer> stack = new MaxStack<>();
		List<Integer> values = Arrays.asList(1, 1, 5, 7, 8, 9, 10, 12, 16, 2, 3, 8, 9, 2, 1, 9, 20, 2, 9, 1, 7, 17, 0);
		values.forEach(stack::push);
		assertThat(stack.size()).isEqualTo(values.size());
		assertThat(stack.max()).isNotEmpty().hasValue(values.stream().reduce(Integer::max).get());

		Collections.reverse(values);
		values.stream().sequential().forEach(value -> assertThat(stack.pop()).isNotEmpty().hasValue(value));
		assertThat(stack.max()).isEmpty();
		assertThat(stack.pop()).isEmpty();
	}

}
