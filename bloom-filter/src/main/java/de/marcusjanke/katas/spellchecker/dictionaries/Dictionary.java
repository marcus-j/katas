package de.marcusjanke.katas.spellchecker.dictionaries;

import java.util.stream.Stream;

public interface Dictionary<T> {

    Stream<T> stream();
}
