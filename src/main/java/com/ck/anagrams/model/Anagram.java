package com.ck.anagrams.model;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Anagram {
    private String id;
    private String word;
    private String orderedChars;
}
