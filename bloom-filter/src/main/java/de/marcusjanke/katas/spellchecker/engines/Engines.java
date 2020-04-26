package de.marcusjanke.katas.spellchecker.engines;

import lombok.experimental.UtilityClass;

import java.util.function.ToIntFunction;

@UtilityClass
public class Engines {

    public static <T> Engine<T> bloomFilterEngine(int maxSize, ToIntFunction<T> hashFunction) {
        return new BloomFilterEngine<>(maxSize, hashFunction);
    }
}
