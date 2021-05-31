package com.ck.anagrams.printer;

import com.ck.anagrams.model.Anagram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramPrinter {
    private static final Logger logger = LoggerFactory.getLogger(AnagramPrinter.class);
    private static final String WORD_SEPARATOR = ", ";

    public void printAnagrams(Map<String, List<Anagram>> anagramMap) {
        var result = new StringBuilder();

        anagramMap.values().forEach(anagrams ->
            result.append(System.lineSeparator())
                    .append(anagrams.stream()
                            .map(Anagram::getWord)
                            .collect(Collectors.joining(WORD_SEPARATOR))));

        var logResult = result.toString();
        logger.info(logResult);
    }
}
