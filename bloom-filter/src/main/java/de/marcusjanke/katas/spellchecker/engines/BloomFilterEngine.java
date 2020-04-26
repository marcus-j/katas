package de.marcusjanke.katas.spellchecker.engines;

import de.marcusjanke.katas.spellchecker.dictionaries.Dictionary;
import lombok.EqualsAndHashCode;

import java.util.function.ToIntFunction;

@EqualsAndHashCode
class BloomFilterEngine<T> implements Engine<T> {

    private final BloomFilter<T> bloomFilter;

    BloomFilterEngine(int maxSize, ToIntFunction<T> hashFunction) {
        bloomFilter = new BloomFilter<>(maxSize, hashFunction);
    }

    @Override
    public void loadDictionary(Dictionary<T> dictionary) {
        dictionary.stream().forEach(bloomFilter::putElement);
    }

    @Override
    public boolean check(T value) {
        return bloomFilter.mightContainElement(value);
    }
}
