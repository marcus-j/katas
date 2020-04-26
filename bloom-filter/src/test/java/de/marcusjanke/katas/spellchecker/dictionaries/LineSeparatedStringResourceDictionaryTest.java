package de.marcusjanke.katas.spellchecker.dictionaries;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toUnmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;

class LineSeparatedStringResourceDictionaryTest {

    @Test
    @DisplayName("should load dictionary from resource path and stream exactly contained elements")
    void shouldLoadDictionaryFromResourcePath() {
        final String resourcePath = "/dictionary/test_dictionary.txt";
        final Dictionary<String> dictionary = new LineSeparatedStringResourceDictionary(resourcePath);

        assertThat(dictionary.stream().collect(toUnmodifiableList())).containsExactlyInAnyOrder("test1", "test11");
    }
}