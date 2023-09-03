package ch2;

import ch2.attempt.FindingFirstNonRepeatedCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FindingFirstNonRepeatedCharacterTest {

    @Test
    @DisplayName("GIVEN a String value WHEN nonRepeatedChar is invoked THEN first non-repeated Character is returned")
    void testNonRepeatedChar() {
        String value = "wie gehts es ihnen";
        Character actual =
                FindingFirstNonRepeatedCharacter.nonRepeatedChar(value);
        Character expected = 'w';

        // Test failed
        Assertions.assertEquals(expected, actual);
    }

}
