package com.ck.anagrams.util;

import com.ck.anagrams.model.Anagram;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AnagramUtilTest {
    private final AnagramUtil anagramUtil = new AnagramUtil();

    @Test
    void findMatchingAnagrams() {
        List<Anagram> anagrams = new ArrayList<>();
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
        anagrams.add(anagram1);
        anagrams.add(anagram2);
        anagrams.add(anagram3);

        Map<String, List<Anagram>> matchingAnagrams = anagramUtil.findMatchingAnagrams(anagrams);

        Map<String, List<Anagram>> expectedAnagrams = new LinkedHashMap<>();
        expectedAnagrams.put("acer", Arrays.asList(anagram2, anagram1));
        assertEquals(expectedAnagrams, matchingAnagrams);
    }
}