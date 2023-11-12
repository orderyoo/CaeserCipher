package com.example.caesercipherprogect;

import java.util.List;

public class CaesarCipher {
    public static String commander(String str, String language, int mov, boolean operation, AlphabetGenerator alphabetGenerator) {
        if (language == "Русский" && operation) {
            return encoder(str, alphabetGenerator.lowercaseAlphabetRu, alphabetGenerator.uppercaseAlphabetRu, mov);
        } else if (language == "Английский" && operation) {
            return encoder(str, alphabetGenerator.lowercaseAlphabetEn, alphabetGenerator.uppercaseAlphabetEn, mov);
        } else if (language == "Русский" && !operation){
            return decoder(str, alphabetGenerator.lowercaseAlphabetRu, alphabetGenerator.uppercaseAlphabetRu, mov);
        } else if (language == "Английский" && !operation) {
            return decoder(str, alphabetGenerator.lowercaseAlphabetEn, alphabetGenerator.uppercaseAlphabetEn, mov);
        }
        return "Ошибка язык не верный";
    }
    public static String encoder(String str, List<Character> lowercaseAlphabet, List<Character> uppercaseAlphabet, int mov) {
        char[] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            if(Character.isLetter(strChar[i])){
                int index = 0;
                if (Character.isLowerCase(strChar[i])){
                    index = lowercaseAlphabet.indexOf(strChar[i]) + mov;
                } else if (Character.isUpperCase(strChar[i])) {
                    index = uppercaseAlphabet.indexOf(strChar[i]) + mov;
                }
                if(index <= lowercaseAlphabet.size()-1){
                    if(lowercaseAlphabet.contains(strChar[i])){
                        strChar[i] = lowercaseAlphabet.get(index);
                    } else {
                        strChar[i] = uppercaseAlphabet.get(index);
                    }
                } else {
                    index -= lowercaseAlphabet.size();
                    if(Character.isLowerCase(strChar[i])){
                        strChar[i] = lowercaseAlphabet.get(index);
                    } else {
                        strChar[i] = uppercaseAlphabet.get(index);
                    }
                }
            }
        }
        String str1 = new String(strChar);
        return str1;
    }
    public static String decoder(String str, List<Character> lowercaseAlphabet, List<Character> uppercaseAlphabet, int mov){
        char[] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            if(lowercaseAlphabet.contains(strChar[i]) || uppercaseAlphabet.contains(strChar[i])){
                int index = 0;
                if (lowercaseAlphabet.contains(strChar[i])){
                    index = lowercaseAlphabet.indexOf(strChar[i]) + lowercaseAlphabet.size();
                } else if (uppercaseAlphabet.contains(strChar[i])) {
                    index = uppercaseAlphabet.indexOf(strChar[i]) + uppercaseAlphabet.size();
                }
                if(index <= lowercaseAlphabet.size()-1){
                    if(lowercaseAlphabet.contains(strChar[i])){
                        strChar[i] = lowercaseAlphabet.get(index);
                    } else {
                        strChar[i] = uppercaseAlphabet.get(index);
                    }
                } else {
                    index -= mov;
                    if(index >= lowercaseAlphabet.size()){
                        index = index-lowercaseAlphabet.size();
                    }
                    if(lowercaseAlphabet.contains(strChar[i])){
                        strChar[i] = lowercaseAlphabet.get(index);
                    } else {
                        strChar[i] = uppercaseAlphabet.get(index);
                    }
                }
            }
        }
        String str1 = new String(strChar);
        return str1;
    }
}
