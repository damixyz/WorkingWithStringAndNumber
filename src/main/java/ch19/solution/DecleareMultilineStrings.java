package ch19.solution;

public class DecleareMultilineStrings {
    private static final String LS = System.lineSeparator();
    String text = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Cras nunc orci, varius id sodales dapibus, suscipit vitae quam.
            Proin porta turpis nec enim aliquet laoreet. Mauris efficitur quam ipsum,
            ut pretium risus rhoncus elementum. Pellentesque habitant morbi
            tristique senectus et netus et malesuada fames ac turpis egestas.
            """;

    String text2 = String.join(LS,

            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Cras nunc orci, varius id sodales dapibus, suscipit vitae quam.",
            "Proin porta turpis nec enim aliquet laoreet. Mauris efficitur quam ipsum,",
            "ut pretium risus rhoncus elementum. Pellentesque habitant morbi",
            "tristique senectus et netus et malesuada fames ac turpis egestas."
    );
}
