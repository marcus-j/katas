package de.marcusjanke.katas.spellchecker.engines;

import lombok.EqualsAndHashCode;

import java.util.BitSet;
import java.util.function.ToIntFunction;

@EqualsAndHashCode
class BloomFilter<T> {

    private final BitSet bitSet;
    private final int maxSize;
    private final ToIntFunction<T> hashFunction;

    BloomFilter(int maxSize, ToIntFunction<T> hashFunction) {
        this.bitSet = new BitSet(maxSize);
        this.maxSize = maxSize;
        this.hashFunction = hashFunction;
    }

    void putElement(T element) {
        bitSet.set(normalizedHash(element));
    }

    boolean mightContainElement(T element) {
        return bitSet.get(normalizedHash(element));
    }

    private int normalizedHash(T element) {
        return hashFunction.applyAsInt(element) % maxSize;
    }
}
