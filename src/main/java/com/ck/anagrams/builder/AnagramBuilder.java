package com.ck.anagrams.builder;

import com.ck.anagrams.model.Anagram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramBuilder {
    public List<Anagram> buildAnagrams(List<String> words) {
        return words.stream()
                .map(word -> Anagram.builder()
                        .word(word)
                        .orderedChars(getOrderedChars(word))
                        .build())
                .collect(Collectors.toList());
    }

    private String getOrderedChars(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
