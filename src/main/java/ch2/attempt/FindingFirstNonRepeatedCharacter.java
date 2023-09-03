package ch2.attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindingFirstNonRepeatedCharacter {
    static Character nonRepeatedChar(String value) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = value.toCharArray();
        for (char ch :
                chars) {
            map.compute(ch, (k, v) -> (v == null) ? 0 : -1);
        }

        System.out.println(map);


        List<Character> nonRepeatedChars = new ArrayList<>();
        map.entrySet().stream().filter((e) -> e.getValue() == 0).forEach((entry) ->
                nonRepeatedChars.add(entry.getKey()));
        System.out.println(nonRepeatedChars);

        return nonRepeatedChars.get(0);

    }
}
