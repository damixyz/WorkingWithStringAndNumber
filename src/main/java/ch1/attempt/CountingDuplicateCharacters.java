package ch1.attempt;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicateCharacters {

    public static void main(String[] args) {
        System.out.println(
                countDuplicate("wiegehtsesihnen")
        );
        System.out.println(
                countDuplicate("gutdankenschon")
        );
    }

    private static Map<Character, Integer> countDuplicate(String value) {
        Map<Character, Integer> result = new HashMap<>(256);

        char[] charSeq = value.toCharArray();
        for (char c :
                charSeq) {
            result.compute(c, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }
}
