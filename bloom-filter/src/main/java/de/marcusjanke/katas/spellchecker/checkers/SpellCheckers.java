package de.marcusjanke.katas.spellchecker.checkers;

import lombok.experimental.UtilityClass;

import java.nio.charset.Charset;
import java.util.function.ToIntFunction;

import static de.marcusjanke.katas.spellchecker.dictionaries.Dictionaries.lineSeparatedStringResourceDictionary;
import static de.marcusjanke.katas.spellchecker.engines.Engines.bloomFilterEngine;

@UtilityClass
public class SpellCheckers {

    public static SpellChecker dictionaryBasedSpellChecker(int bloomFilterSize, ToIntFunction<String> hashFunction, String resourcePath, Charset charset) {
        return new DictionaryBasedSpellChecker(bloomFilterEngine(bloomFilterSize, hashFunction), lineSeparatedStringResourceDictionary(resourcePath, charset));
    }
}
