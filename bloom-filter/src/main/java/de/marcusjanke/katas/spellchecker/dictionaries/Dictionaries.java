package de.marcusjanke.katas.spellchecker.dictionaries;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Dictionaries {

    public static Dictionary<String> lineSeparatedStringResourceDictionary(String resourcePath) {
        return new LineSeparatedStringResourceDictionary(resourcePath);
    }
}
