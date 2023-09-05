package ch4.attempt;

public class ContainsOnlyDigits {

    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDigitsAnyMatchFunction(String str) {
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }

    public static boolean containsOnlyDigitsRegx(String str) {
        return str.matches("[0-9]+");
    }

}
