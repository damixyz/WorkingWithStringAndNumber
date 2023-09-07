package ch6.solution;

public class CountingOccurrancesOfCertainCharacter {

    public static int countOccurrancesOfACertainCharacter(String str, char ch) {
        return str.length() -
                str.replace(String.valueOf(ch), "")
                        .length();
    }

    public static int countOccurrancesOfACertainCharacterUniCode(String str, String ch) {
        if (ch.codePointCount(0, ch.length()) > 1) {
            // there is more than 1 Unicode character in the given String
            return -1;
        }

        int result = str.length() -
                str.replace(ch, "").length();
        // if ch.length() return 2 then this is a Unicode surrogate pair

        return ch.length() == 2 ? result / 2 : result;
    }


    public static int countOccurrancesOfACertainCharacterForLoop(String str, char ch) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }


    public static long countOccurrancesOfACertainCharacterStream(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
