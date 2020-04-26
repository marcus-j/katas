package de.marcusjanke.katas.spellchecker.checkers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.marcusjanke.katas.spellchecker.checkers.SpellCheckers.dictionaryBasedSpellChecker;
import static de.marcusjanke.katas.spellchecker.dictionaries.Dictionaries.lineSeparatedStringResourceDictionary;
import static de.marcusjanke.katas.spellchecker.engines.Engines.bloomFilterEngine;
import static de.marcusjanke.katas.spellchecker.engines.HashFunctions.MURMUR_3;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static org.assertj.core.api.Assertions.assertThat;

class SpellCheckersTest {

    private static final int MAX_SIZE = 100_000;

    @Test
    @DisplayName("should create DictionaryBasedSpellChecker with convenience method")
    void shouldCreateDictionaryBasedSpellChecker() {
        final String resourcePath = "/dictionary/wordlist.txt";
        final SpellChecker actualSpellChecker = dictionaryBasedSpellChecker(MAX_SIZE, MURMUR_3, resourcePath, ISO_8859_1);

        assertThat(actualSpellChecker).isEqualTo(new DictionaryBasedSpellChecker(bloomFilterEngine(MAX_SIZE, MURMUR_3), lineSeparatedStringResourceDictionary(resourcePath, ISO_8859_1)));
    }

    @Test
    @DisplayName("should return true for all dictionary items")
    void shouldReturnTrueForAllDictionaryItems() {
        final String resourcePath = "/dictionary/wordlist.txt";
        final SpellChecker actualSpellChecker = dictionaryBasedSpellChecker(MAX_SIZE, MURMUR_3, resourcePath, ISO_8859_1);

        assertThat(lineSeparatedStringResourceDictionary(resourcePath, ISO_8859_1).stream().anyMatch(word -> !actualSpellChecker.check(word))).isFalse();
    }
}