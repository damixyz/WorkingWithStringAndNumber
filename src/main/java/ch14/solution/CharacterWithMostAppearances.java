package ch14.solution;

import java.util.*;
import java.util.stream.Collectors;

public class CharacterWithMostAppearances {

    private static final int EXTENDED_ASCII_CODES = 256;

    public static Map.Entry<Character, Integer> maxOccurenceCharacter(String str) {

        Map<Character, Integer> counter = new HashMap<>();
        char[] chStr = str.toCharArray();

        for (int i = 0; i < chStr.length; i++) {
            char currentCh = chStr[i];

            if (!Character.isWhitespace(currentCh)) { // Ignore space
                Integer noCh = counter.get(currentCh);
                if (noCh == null) {
                    counter.put(currentCh, 1);
                } else {
                    counter.put(currentCh, ++noCh);
                }

            }
        }

        int maxOccurences = Collections.max(counter.values());
        char maxCharacter = Character.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry :
                counter.entrySet()) {
            if (entry.getValue() == maxOccurences) {
                maxCharacter = entry.getKey();
            }

        }
        return new AbstractMap.SimpleEntry(maxCharacter, maxOccurences);
    }

    public static Map.Entry<Character, Integer> maxOccurenceCharacterAscii(String str) {

        int maxOccurrences = -1;
        char maxCharacter = Character.MIN_VALUE;
        char[] chStr = str.toCharArray();
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < chStr.length; i++) {
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) { // ignoring space
                int code = currentCh;
                asciiCodes[code]++;
                if (asciiCodes[code] > maxOccurrences) {
                    maxOccurrences = asciiCodes[code];
                    maxCharacter = currentCh;
                }
            }
        }
        return new AbstractMap.SimpleEntry(maxCharacter, maxOccurrences);
    }

    public static Map.Entry<Character, Long> maxOccurenceCharacterStream(String str) {

        return str.chars()
                .filter(c -> !Character.isWhitespace(c)) // ignore space
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(p -> new AbstractMap.SimpleEntry<>(p.getKey(), p.getValue()))
                .orElse(new AbstractMap.SimpleEntry<>(Character.MIN_VALUE, -1L));

    }

}
