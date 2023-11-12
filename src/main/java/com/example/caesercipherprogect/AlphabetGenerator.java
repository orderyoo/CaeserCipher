package com.example.caesercipherprogect;

import java.util.ArrayList;
import java.util.List;

public class AlphabetGenerator {
    List<Character> uppercaseAlphabetRu = new ArrayList<Character>(){{
        for(char letter = 'А'; letter <= 'Я'; letter++) {
            if (letter == 'Ж') {
                add('Ё');
            }
            add(letter);
        }
    }};
    List<Character> lowercaseAlphabetRu = new ArrayList<Character>(){{
        for (char letter = 'а'; letter <= 'я'; letter++) {
            if (letter == 'ж') {
                add('ё');
            }
            add(letter);
        }
    }};
    List<Character> uppercaseAlphabetEn = new ArrayList<Character>() {{
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            add(letter);
        }
    }};
    List<Character> lowercaseAlphabetEn = new ArrayList<Character>() {{
        for (char letter = 'a'; letter <= 'z'; letter++) {
            add(letter);
        }
    }};
}