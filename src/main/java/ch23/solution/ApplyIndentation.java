package ch23.solution;

import java.util.Arrays;
import java.util.List;

public class ApplyIndentation {

    private static final String days = "Sunday" +
            "Monday\n" +
            "Tuesday\n" +
            "Wednesday\n" +
            "Thursday\n" +
            "Friday\n" +
            "Saturday";

    public static void main(String[] args) {
        System.out.println(days.indent(10));

        List<String> days = Arrays.asList(
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        );
        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i).indent(i));
        }

        // Indent depending on the length of the String value
        days.forEach(d ->
                System.out.println(d.indent(d.length())));
    }
}
