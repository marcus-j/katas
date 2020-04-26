package de.marcusjanke.katas.spellchecker.dictionaries;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.String.format;

@RequiredArgsConstructor
class LineSeparatedStringResourceDictionary implements Dictionary<String> {

    private final String resourcePath;

    @Override
    public Stream<String> stream() {
        try {
            return  Files.lines(Paths.get(LineSeparatedStringResourceDictionary.class.getResource(resourcePath).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new IllegalArgumentException(format("Failed loading from %s", resourcePath));
        }
    }
}
