package de.marcusjanke.katas.spellchecker.dictionaries;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

class DictionariesTest {

    @Test
    @DisplayName("should create LineSeparatedStringResourceDictionary with convenience method")
    void shouldCreateLineSeparatedStringResourceDictionary() {
        final String resourcePath = "some-path";
        final Dictionary<String> actualDictionary = Dictionaries.lineSeparatedStringResourceDictionary(resourcePath, UTF_8);

        assertThat(actualDictionary).isEqualTo(new LineSeparatedStringResourceDictionary(resourcePath, UTF_8));
    }
}