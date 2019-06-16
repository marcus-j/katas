package de.marcusjanke.katas.encryption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13EncrypterTest {

    private Encrypter encrypter;

    @BeforeEach
    void setUp() {
        encrypter = new Rot13Encrypter();
    }

    @Test
    void shouldEncryptText() {
        assertEquals("URYYB", encrypter.encrypt("Hello"));
    }

    @Test
    void shouldNotEncryptNoneLetters() {
        assertEquals("URYYB, JBEYQ", encrypter.encrypt("Hello, World"));
        assertEquals("URYYB, 1234", encrypter.encrypt("Hello, 1234"));
    }
}