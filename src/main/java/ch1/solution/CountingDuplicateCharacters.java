package ch1.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {

    public Map<Character, Integer> countDuplicateCharactersForLoop(String str) {
        Map<Character, Integer> result = new HashMap<>();

        // or use for(char ch: str.toCharArray()) {...}
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public Map<Character, Long> countDuplicateCharactersStream(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    }

    public Map<String, Integer> countDuplicateCharactersForLoopUniCode(String str) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i); // the representation of the Char value
            String ch = String.valueOf(Character.toChars(cp)); // the representation of the String value
            if (Character.charCount(cp) == 2) { // This check how much Char space this String occupies
                // 2 means a surrogate pair then move to the next character
                i++;
            }
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public Map<String, Long> countDuplicateCharactersStreamUniCode(String str) {
        return str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
