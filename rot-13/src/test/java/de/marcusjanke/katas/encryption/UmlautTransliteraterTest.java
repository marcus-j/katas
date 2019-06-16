package de.marcusjanke.katas.encryption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UmlautTransliteraterTest {

    private UmlautTransliterater transliterater;

    @BeforeEach
    void setUp() {
        transliterater = new UmlautTransliterater();
    }

    @Test
    void shouldTransliterateUmlautsToUpperCase() {
        assertEquals("AE", transliterater.transliterateToUpperCase("ä"));
        assertEquals("UE", transliterater.transliterateToUpperCase("ü"));
        assertEquals("OE", transliterater.transliterateToUpperCase("ö"));
        assertEquals("SS", transliterater.transliterateToUpperCase("ß"));
        assertEquals("AE", transliterater.transliterateToUpperCase("Ä"));
        assertEquals("UE", transliterater.transliterateToUpperCase("Ü"));
        assertEquals("OE", transliterater.transliterateToUpperCase("Ö"));
    }
}