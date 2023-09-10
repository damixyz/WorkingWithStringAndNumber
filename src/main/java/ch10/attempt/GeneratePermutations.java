package ch10.attempt;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class GeneratePermutations {

    public static void permutations(String str) {
        permuteAndPrint("", str);
    }

    private static void permuteAndPrint(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permuteAndPrint(
                        prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i)
                );
            }
        }
    }

    private static Set<String> permuteAndStore(String str) {
        return permuteAndStore("", str);
    }

    private static Set<String> permuteAndStore(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();

        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(
                        permuteAndStore(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }

    private static void permuteAndPrintStream(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.println(prefix + " ");
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permuteAndPrintStream(
                            prefix + str.charAt(i),
                            str.substring(i + 1, n) + str.substring(0, i)));

        }
    }

    public static void main(String[] args) {
        permutations("ABC");
        System.out.println(permuteAndStore("TESTLOS"));
        permuteAndPrintStream("", "LOSGEHTS");
    }
}
