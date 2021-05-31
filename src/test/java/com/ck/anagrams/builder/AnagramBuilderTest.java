package com.ck.anagrams.builder;

import com.ck.anagrams.model.Anagram;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramBuilderTest {
    private AnagramBuilder anagramBuilder = new AnagramBuilder();

    @Test
    void buildAnagrams() {
        List<String> words = Arrays.asList("race","care","test");
        List<Anagram> anagrams = anagramBuilder.buildAnagrams(words);

        List<Anagram> expectedAnagrams = new ArrayList<>();
        Anagram anagram1 = Anagram.builder()
                .word("race")
                .orderedChars("acer")
                .build();
        Anagram anagram2 = Anagram.builder()
                .word("care")
                .orderedChars("acer")
                .build();
        Anagram anagram3 = Anagram.builder()
                .word("test")
                .orderedChars("estt")
                .build();
        expectedAnagrams.add(anagram1);
        expectedAnagrams.add(anagram2);
        expectedAnagrams.add(anagram3);

        assertEquals(expectedAnagrams, anagrams);
    }
}