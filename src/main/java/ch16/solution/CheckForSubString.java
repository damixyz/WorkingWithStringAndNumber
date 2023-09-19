package ch16.solution;

import java.util.regex.Pattern;

public class CheckForSubString {
    static String text = "Hallo welt! Wir geht's dir";
    static String subtext = "elt";

    public static boolean containsStringMethod(String text, String subtext) {
        return text.contains(subtext);
    }

    public static boolean containsStringLastIndexOf(String text, String subtext) {
        return text.indexOf(subtext) != -1;
    }

    public static boolean containsStringRegx(String text, String subtext) {
        return text.matches("(?i).*" + Pattern.quote(subtext) + ".*");
    }
}
