package ch17.attempt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingSubstringOccurences {
    public static int countStringInString(String string, String toFind) {

        int positon = 0;
        int count = 0;
        int n = toFind.length();

        while ((positon = string.indexOf(toFind, positon)) != -1) {
            positon = positon + n;
            count++;
        }
        return count;
    }

    public static int countStringInStringSplit(String string, String toFind) {
        int result = string.split(Pattern.quote(toFind), -1).length - 1;
        return Math.max(result, 0);
    }

    public static int countStringInStringRegx(String string, String toFind) {

        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);

        int position = 0;
        int count = 0;

        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }

        return count;
    }
}
