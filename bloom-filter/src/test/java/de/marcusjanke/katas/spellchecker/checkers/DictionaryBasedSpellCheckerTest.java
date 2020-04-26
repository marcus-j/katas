package de.marcusjanke.katas.spellchecker.checkers;

import de.marcusjanke.katas.spellchecker.dictionaries.Dictionary;
import de.marcusjanke.katas.spellchecker.engines.Engine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DictionaryBasedSpellCheckerTest {

    @Mock
    private Engine<String> engine;
    @Mock
    private Dictionary<String> dictionary;

    @Test
    @DisplayName("should load directory on creation")
    void shouldLoadDirectoryOnCreation() {
        new DictionaryBasedSpellChecker(engine, dictionary);

        verify(engine).loadDictionary(dictionary);
    }

    @Test
    @DisplayName("should use engine to determine check result")
    void shouldUseEngineToDetermineCheckResult() {
        final SpellChecker spellChecker = new DictionaryBasedSpellChecker(engine, dictionary);
        final String word = "my-word";
        when(engine.check(word)).thenReturn(true);

        assertThat(spellChecker.check(word)).isTrue();
        verify(engine).check(eq(word));
    }
}