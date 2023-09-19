package ch20.solution;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatenateStringNTimes {
    private static final String TEXT = "hello";

    public static String concatRepeatStringBuilder(String str, int n) {
        StringBuilder sb = new StringBuilder(str.length() * n);
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String concatRepeat(String str, int n) {
        return str.repeat(n);
    }

    /**
     * Other Solutions
     */
    String resultStringJoin = String.join("", Collections.nCopies(5, TEXT));
    String resultStream = Stream.generate(() -> TEXT)
            .limit(5)
            .collect(Collectors.joining());
    String resultFormat = String.format("%0" + 5 + "d", 0)
            .replace("0", TEXT);
    String resultChar = new String(new char[5]).replace("\0", TEXT);
}
