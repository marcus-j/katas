package de.marcusjanke.katas.encryption;

import java.util.function.Function;
import java.util.function.IntFunction;

import static java.util.stream.Collectors.joining;

class UmlautTransliterater {

    String transliterateToUpperCase(String original) {
        return original.chars().mapToObj(toChar()).map(toUpperCase()).map(transliterateChar()).collect(joining());
    }

    private static Function<Character, String> transliterateChar() {
        return character -> {
            switch (character){
                case 'Ä': return "AE";
                case 'Ö': return "OE";
                case 'Ü': return "UE";
                case 'ß': return "SS";
                default: return String.valueOf(character);
            }
        };
    }

    private static Function<Character, Character> toUpperCase() {
        return Character::toUpperCase;
    }

    private static IntFunction<Character> toChar() {
        return bytes -> (char) bytes;
    }
}
