package ch11;

import java.util.stream.IntStream;

public class CheckForPalindrome {

    public static boolean isPalindrome(String str) {
        return str.contentEquals(new StringBuilder(str).reverse());
    }

    public static boolean isPalindromeWhileLoop(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeForLoop(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - 1)) return false;
        }
        return true;
    }

    public static boolean isPalindromeStream(String str) {
        return IntStream.range(0, str.length() / 2)
                .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }
}
