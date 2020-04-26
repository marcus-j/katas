package de.marcusjanke.katas.spellchecker.engines;

import de.marcusjanke.katas.spellchecker.dictionaries.Dictionary;

public interface Engine<T> {

    void loadDictionary(Dictionary<T> dictionary);

    boolean check(T value);
}
