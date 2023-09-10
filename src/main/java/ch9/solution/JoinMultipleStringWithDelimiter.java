package ch9.solution;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class JoinMultipleStringWithDelimiter {

    public static String joinByDelimiter(char delimiter, String... args) {

        StringBuilder result = new StringBuilder();

        int i;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);

        }
        result.append(args[i]);

        return result.toString();
    }

    public static String joinByDelimiterStringJoiner(char delimiter, String... args) {
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for (String arg :
                args) {
            joiner.add(arg);
        }

        return joiner.toString();
    }

    public static String joinByDelimiterStream(char delimiter, String... args) {
        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }


    public static void main(String[] args) {
        String result = String.join(" ", "wie", "geht's", "dir");
    }
}
