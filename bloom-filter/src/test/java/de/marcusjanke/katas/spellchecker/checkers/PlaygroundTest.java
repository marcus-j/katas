package de.marcusjanke.katas.spellchecker.checkers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static de.marcusjanke.katas.spellchecker.checkers.SpellCheckers.dictionaryBasedSpellChecker;
import static de.marcusjanke.katas.spellchecker.dictionaries.Dictionaries.lineSeparatedStringResourceDictionary;
import static de.marcusjanke.katas.spellchecker.engines.HashFunctions.MURMUR_3;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.IntStream.rangeClosed;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Slf4j
class PlaygroundTest {

    private static final int MAX_SIZE = 100_000;

    @Test
    @DisplayName("Compares random words against bloom filtered dictionary. Feel free to play around")
    void compareAgainstActualDictionary() {
        final String resourcePath = "/dictionary/wordlist.txt";
        final SpellChecker spellChecker = dictionaryBasedSpellChecker(MAX_SIZE, MURMUR_3, resourcePath, ISO_8859_1);
        final List<String> wholeDictionary = lineSeparatedStringResourceDictionary(resourcePath, ISO_8859_1).stream().collect(toUnmodifiableList());

        final int total = 1_000;
        final AtomicInteger hits = new AtomicInteger();
        final AtomicInteger correctHits = new AtomicInteger();
        rangeClosed(1, total).forEach(i -> {
            final String word = randomAlphabetic(3);
            if (spellChecker.check(word)) {
                hits.incrementAndGet();
                if (wholeDictionary.contains(word)) {
                    correctHits.incrementAndGet();
                }
            }
        });

        log.info(format("Hit %s out of %s, of which %s were correct", hits, total, correctHits));
    }
}