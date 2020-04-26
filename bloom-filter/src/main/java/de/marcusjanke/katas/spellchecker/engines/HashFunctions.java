package de.marcusjanke.katas.spellchecker.engines;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.MurmurHash3;

import java.util.Objects;
import java.util.function.ToIntFunction;

import static java.lang.Math.abs;

@UtilityClass
public class HashFunctions {

    public static final ToIntFunction<String> MURMUR_3 = word -> Objects.isNull(word) ? 0 : abs(MurmurHash3.hash32x86(word.getBytes()));
    public static final ToIntFunction<String> STRING_LENGTH = word -> Objects.isNull(word) ? 0 : word.length();
}
