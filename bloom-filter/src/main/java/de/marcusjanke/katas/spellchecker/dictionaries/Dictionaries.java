package de.marcusjanke.katas.spellchecker.dictionaries;

import lombok.experimental.UtilityClass;

import java.nio.charset.Charset;

@UtilityClass
public class Dictionaries {

    public static Dictionary<String> lineSeparatedStringResourceDictionary(String resourcePath, Charset charset) {
        return new LineSeparatedStringResourceDictionary(resourcePath, charset);
    }
}
