package de.marcusjanke.katas.spellchecker.engines;

import de.marcusjanke.katas.spellchecker.dictionaries.Dictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static de.marcusjanke.katas.spellchecker.dictionaries.Dictionaries.lineSeparatedStringResourceDictionary;
import static org.assertj.core.api.Assertions.assertThat;

class BloomFilterEngineTest {

    private static final ToIntFunction<String> HASH_BY_STRING_LENGTH_FUNCTION = String::length;

    @Test
    @DisplayName("should use dictionary for initial load of bloom filter")
    void shouldUseDictionaryForInitialLoadOfBloomFilter() {
        final BloomFilterEngine<String> bloomFilterEngine = new BloomFilterEngine<>(10, HASH_BY_STRING_LENGTH_FUNCTION);
        final String resourcePath = "/dictionary/test_dictionary.txt";
        final Dictionary<String> dictionary = lineSeparatedStringResourceDictionary(resourcePath);

        bloomFilterEngine.loadDictionary(dictionary);

        assertThat(bloomFilterEngine.check("test1")).isTrue();
        assertThat(bloomFilterEngine.check("test11")).isTrue();
        assertThat(bloomFilterEngine.check("test111")).isFalse();
    }
}