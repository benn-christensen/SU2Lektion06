package exercise02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YatzyCalculatorTest {

    @Test
    void testCalculateOnePairs() {
        YatzyCalculator yatzyCalculator = new YatzyCalculator();
        int result = yatzyCalculator.calculateOnePairs();
        assertEquals(12, result);
    }

    @Test
    void testCalculateThreeOfAKind() {
        YatzyCalculator yatzyCalculator = new YatzyCalculator();
        int result = yatzyCalculator.calculateThreeOfAKind();
        assertEquals(9, result);
    }

}