package ch24.solution;

import java.util.stream.Stream;

public class TransformingStrings {
    // hello world
    String resultMap = Stream.of("hello")

            .map(s -> s + " world")
            .findFirst()
            .get();

    // GOOOOOOOOOOOOOOOOOOOOL! GOOOOOOOOOOOOOOOOOOOOL!
    String resultMap2 = Stream.of("gooool!")
            .map(String::toUpperCase)
            .map(s -> s.repeat(2))
            .map(s -> s.replaceAll("o", "OOOO"))
            .findFirst()
            .get();

    /**
     * Using String.transform()
     */

    // hello world
    String result3 = "hello".transform(s -> s + " world!");

    // GOOOOOOOOOOOOOOOOOOOOL! GOOOOOOOOOOOOOOOOOOOOL!
    String result4 = "gooool! ".transform(String::toLowerCase)
            .transform(s -> s.repeat(2))
            .transform(s -> s.replaceAll("o", "OOOO"));

}
