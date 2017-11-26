package de.marcusjanke.katas.maxstack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * A Stack that provides direct access to the 'maximum' value on the stack
 * 
 * @author marcus
 *
 * @param <T>
 */
public class MaxStack<T extends Comparable<T>> {

	private List<T> data = Collections.<T>synchronizedList(new ArrayList<>());
	private List<T> max = Collections.<T>synchronizedList(new ArrayList<>());

	/**
	 * add new element to the stack
	 * 
	 * @param item
	 */
	public synchronized void push(T item) {
		data.add(item);
		if (max.isEmpty() || item.compareTo(max.get(max.size() - 1)) > 0) {
			max.add(item);
		}
	}

	/**
	 * get top element from the stack if available
	 * 
	 * @return Optional<T>
	 */
	public synchronized Optional<T> pop() {
		Optional<T> result = Optional.empty();
		if (!data.isEmpty()) {
			result = Optional.of(data.get(data.size() - 1));
			data.remove(data.size() - 1);
			if (!max.isEmpty() && result.get().compareTo(max.get(max.size() - 1)) == 0) {
				max.remove(max.size() - 1);
			}
		}
		return result;
	}

	/**
	 * get current 'maximum' value on the stack, does not remove value from the
	 * stack
	 * 
	 * @return Optional<T>
	 */
	public Optional<T> max() {
		Optional<T> result = Optional.empty();
		if (!max.isEmpty()) {
			result = Optional.of(max.get(max.size() - 1));
		}
		return result;
	}

	/**
	 * current stack size
	 * 
	 * @return stack size
	 */
	public int size() {
		return data.size();
	}
}
