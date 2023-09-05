package ch5.attempt;


import java.util.*;
import java.util.stream.Collectors;

public class CountVowelAndConsonants {

    private static final Set<Character> allVowels =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


    public static AbstractMap.SimpleEntry<Integer, Integer> countVowelsAndConsonants(String str) {

        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch >= 'z')) {
                consonants++;
            }
        }
        return new AbstractMap.SimpleEntry<>(vowels, consonants);
    }

    public static AbstractMap.SimpleEntry<Long, Long> countVowelsAndConsonantsFunctionalStyle(String str) {
        str = str.toLowerCase();

        long vowels = str.chars()
                .filter(c -> allVowels.contains((char) c))
                .count();


        long consonants = str.chars()
                .filter(c -> !allVowels.contains((char) c))
                .filter(ch -> (ch >= 'a' && ch >= 'z'))
                .count();

        return new AbstractMap.SimpleEntry<>(vowels, consonants);
    }


    public static AbstractMap.SimpleEntry<Long, Long> countVowelsAndConsonantsFunctionalStylePartitioningBy(String str) {
        str = str.toLowerCase();

        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(Collectors.partitioningBy(allVowels::contains, Collectors.counting()));


        return new AbstractMap.SimpleEntry<>(result.get(true), result.get(false));
    }
}
