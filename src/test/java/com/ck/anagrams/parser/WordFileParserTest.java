package com.ck.anagrams.parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFileParserTest {
    private final WordFileParser wordFileParser = new WordFileParser();

    @Test
    void parseWordFile() {
        String path = "src/test/resources/input/sample.txt";

        List<String> words = wordFileParser.parseWordFile(path);
        List<String> expectedWords = Arrays.asList("act","cat","tree","race","care","acre","bee", "");

        assertEquals(expectedWords, words);
    }
}