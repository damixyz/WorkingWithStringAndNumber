package ch13;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveGivenCharacter {
    public static String removeCharacter(String str, char ch) {
        return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
    }

    public static String removeCharacterForLoop(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char c :
                chars) {
            if (c != ch) sb.append(c);
        }
        return sb.toString();
    }


    public static String removeCharacterStream(String str, char ch) {
        return str.chars()
                .filter(c -> c != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String removeCharacterStreamUnicode(String str, String ch) {
        int codePoint = ch.codePointAt(0);


        return str.codePoints()
                .filter(c -> c != codePoint)
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.joining());
    }
}
