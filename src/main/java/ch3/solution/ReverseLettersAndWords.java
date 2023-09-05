package ch3.solution;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseLettersAndWords {

    private final static String WHITESPACE = " ";
    private final static Pattern PATTERN = Pattern.compile(" +");

    public String reverseWords(String str) {

        String[] words = str.split(WHITESPACE);
        StringBuilder result = new StringBuilder();

        for (String word :
                words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            result.append(reverseWord).append(WHITESPACE);
        }
        return result.toString();
    }

    public static String reverseWordStream(String str) {
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    public String reverse(String str) {
        // Simple making use of the Java language API
        return new StringBuilder(str).reverse().toString();
    }
}
