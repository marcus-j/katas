package de.marcusjanke.katas.spellchecker.engines;

import de.marcusjanke.katas.spellchecker.dictionaries.Dictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.marcusjanke.katas.spellchecker.dictionaries.Dictionaries.lineSeparatedStringResourceDictionary;
import static de.marcusjanke.katas.spellchecker.engines.HashFunctions.STRING_LENGTH;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

class BloomFilterEngineTest {

    @Test
    @DisplayName("should use dictionary for initial load of bloom filter")
    void shouldUseDictionaryForInitialLoadOfBloomFilter() {
        final BloomFilterEngine<String> bloomFilterEngine = new BloomFilterEngine<>(10, STRING_LENGTH);
        final String resourcePath = "/dictionary/test_dictionary.txt";
        final Dictionary<String> dictionary = lineSeparatedStringResourceDictionary(resourcePath, UTF_8);

        bloomFilterEngine.loadDictionary(dictionary);

        assertThat(bloomFilterEngine.check("test1")).isTrue();
        assertThat(bloomFilterEngine.check("test11")).isTrue();
        assertThat(bloomFilterEngine.check("test111")).isFalse();
    }
}