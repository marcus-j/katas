package de.marcusjanke.katas.spellchecker.engines;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

class BloomFilterTest {

    @Test
    void shouldApplyHashFunction() {
        final ToIntFunction<String> hashFunction = String::length;
        var bloomFilter = new BloomFilter<>(2, hashFunction);


    }
}