package com.ck.anagrams.model;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Anagram {
    public String id;
    public String word;
    public String orderedChars;
}
