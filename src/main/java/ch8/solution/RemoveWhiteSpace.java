package ch8.solution;

import java.util.regex.Pattern;

public class RemoveWhiteSpace {
    public static String removeWhiteScape(String str) {
        // Does the same as below
//        Pattern.compile("\\s").matcher(str).replaceAll(str)

        return str.replaceAll("\\s", "");
    }
}
