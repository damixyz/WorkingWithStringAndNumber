package ch15.solution;

import ch15.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayOfStringsByLength {
    public static void sortArrayByLength(String[] strs, Sort direction) {
        if (direction.equals(Sort.ASC)) {
//            Arrays.sort(strs, (String s1, String s2) ->
//                    Integer.compare(s1.length(), s2.length()));
            Arrays.sort(strs, Comparator.comparingInt(String::length));
        } else {
//            Arrays.sort(strs, (String s1, String s2) ->
//                    (-1) * Integer.compare(s1.length(), s2.length()));
            Arrays.sort(strs,
                    Comparator.comparingInt(String::length).reversed());
        }
    }

    public static String[] sortArrayByLengthStream(String[] strs, Sort direction) {
        if (direction.equals(Sort.ASC)) {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }
    }
}
