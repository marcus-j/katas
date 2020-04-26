package de.marcusjanke.katas.spellchecker.engines;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.marcusjanke.katas.spellchecker.engines.HashFunctions.STRING_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

class EnginesTest {

    private static final int MAX_SIZE = 10;

    @Test
    @DisplayName("should create BloomFilterEngine with convenience method")
    void shouldCreateLineSeparatedStringResourceDictionary() {
        final Engine<String> actualEngine = Engines.bloomFilterEngine(MAX_SIZE, STRING_LENGTH);

        assertThat(actualEngine).isEqualTo(new BloomFilterEngine<>(MAX_SIZE, STRING_LENGTH));
    }
}