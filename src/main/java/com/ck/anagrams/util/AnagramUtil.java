package com.ck.anagrams.util;

import com.ck.anagrams.model.Anagram;
import java.util.*;
import java.util.stream.Collectors;

public class AnagramUtil {
    public Map<String, List<Anagram>> findMatchingAnagrams(List<Anagram> anagrams) {
        anagrams.sort(Comparator.comparing(Anagram::getWord));

        Map<String, List<Anagram>> anagramMap = anagrams.stream()
                .collect(Collectors.groupingBy(Anagram::getOrderedChars));

        return filterAndSortAnagramMap(anagramMap);
    }

    private Map<String, List<Anagram>> filterAndSortAnagramMap(Map<String, List<Anagram>> map) {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 2)
                .sorted(Comparator.comparing(o -> o.getValue().get(0).getWord()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
