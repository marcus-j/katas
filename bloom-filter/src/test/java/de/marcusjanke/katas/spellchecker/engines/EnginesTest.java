package de.marcusjanke.katas.spellchecker.engines;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.assertj.core.api.Assertions.assertThat;

class EnginesTest {

    private static final ToIntFunction<String> HASH_BY_STRING_LENGTH_FUNCTION = String::length;
    private static final int MAX_SIZE = 10;

    @Test
    @DisplayName("should create BloomFilterEngine with convenience method")
    void shouldCreateLineSeparatedStringResourceDictionary() {
        final Engine<String> actualEngine = Engines.bloomFilterEngine(MAX_SIZE, HASH_BY_STRING_LENGTH_FUNCTION);

        assertThat(actualEngine).isEqualTo(new BloomFilterEngine<>(MAX_SIZE, HASH_BY_STRING_LENGTH_FUNCTION));
    }
}