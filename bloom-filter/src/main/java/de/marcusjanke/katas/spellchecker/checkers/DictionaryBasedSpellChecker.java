package de.marcusjanke.katas.spellchecker.checkers;

import de.marcusjanke.katas.spellchecker.dictionaries.Dictionary;
import de.marcusjanke.katas.spellchecker.engines.Engine;

class DictionaryBasedSpellChecker implements SpellChecker {

    private final Engine<String> engine;

    DictionaryBasedSpellChecker(Engine<String> engine, Dictionary<String> dictionary) {
        this.engine = engine;
        this.engine.loadDictionary(dictionary);
    }

    public boolean check(String word) {
        return engine.check(word);
    }
}