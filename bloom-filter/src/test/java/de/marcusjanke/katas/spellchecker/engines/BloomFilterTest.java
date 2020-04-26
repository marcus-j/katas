package de.marcusjanke.katas.spellchecker.engines;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static de.marcusjanke.katas.spellchecker.engines.HashFunctions.STRING_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

class BloomFilterTest {

    @Test
    @DisplayName("should apply a given hash function for updating the underlying bit set")
    void shouldApplyHashFunction() {
        final BloomFilter<String> bloomFilter = new BloomFilter<>(3, STRING_LENGTH);
        bloomFilter.putElement("");
        bloomFilter.putElement("1");

        assertThat(bloomFilter.mightContainElement("")).isTrue();
        assertThat(bloomFilter.mightContainElement("1")).isTrue();
        assertThat(bloomFilter.mightContainElement("11")).isFalse();
    }

    @Test
    @DisplayName("should limit bit set size and truncate longer hashes by applying a modulo operation. Hence, setting 'wrongish' bits")
    void shouldLimitBitSetSize() {
        final BloomFilter<String> bloomFilter = new BloomFilter<>(2, STRING_LENGTH);
        bloomFilter.putElement("1");
        bloomFilter.putElement("11");

        assertThat(bloomFilter.mightContainElement("")).isTrue();
        assertThat(bloomFilter.mightContainElement("1")).isTrue();
        assertThat(bloomFilter.mightContainElement("11")).isTrue();
    }
}