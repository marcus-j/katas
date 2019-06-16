package de.marcusjanke.katas.encryption;

import java.util.Optional;
import java.util.function.Function;

import static java.lang.Character.isAlphabetic;
import static java.util.stream.Collectors.joining;

public class Rot13Encrypter implements Encrypter {

    private static final int SHIFT_VALUE = 13;
    private static final char MAX = 'Z';
    private static final char MIN = 'A';

    @Override
    public String encrypt(String plainText) {
        return Optional.ofNullable(plainText).map(toEncryptedText()).orElse(null);
    }

    private static Function<String, String> toEncryptedText() {
        final UmlautTransliterater transliterater = new UmlautTransliterater();
        return text -> transliterater.transliterateToUpperCase(text).chars()
                .mapToObj(value -> (char)value)
                .map(toShiftedCharIfAphabetic())
                .map(String::valueOf)
                .collect(joining());
    }

    private static Function<Character, Character> toShiftedCharIfAphabetic() {
        return c -> isAlphabetic(c) ? toShiftedChar(c) : c;
    }

    private static char toShiftedChar(Character c) {
        return (char)(c + SHIFT_VALUE <= MAX ? c + SHIFT_VALUE : MIN + (c + SHIFT_VALUE - MAX - 1));
    }
}
