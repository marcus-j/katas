package de.marcusjanke.katas.spellchecker.dictionaries;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.String.format;

@EqualsAndHashCode
@RequiredArgsConstructor
class LineSeparatedStringResourceDictionary implements Dictionary<String> {

    private final String resourcePath;
    private final Charset charset;

    @Override
    public Stream<String> stream() {
        try {
            return  Files.lines(Paths.get(LineSeparatedStringResourceDictionary.class.getResource(resourcePath).toURI()), charset);
        } catch (IOException | URISyntaxException e) {
            throw new IllegalArgumentException(format("Failed loading from %s", resourcePath));
        }
    }
}
