package com.ck.anagrams.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WordFileParser {
    private static final Logger logger = LoggerFactory.getLogger(WordFileParser.class);

    public List<String> parseWordFile(String path) {
        List<String> wordList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(wordList::add);
        } catch (IOException e) {
            logger.error("Error reading file {} !", path, e);
        }
        return wordList;
    }
}
