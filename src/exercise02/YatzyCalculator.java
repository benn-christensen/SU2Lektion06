package exercise02;

import exercise02.models.RaffleCup;

public class YatzyCalculator {
    private int[] eyesDistribution = new int[6];

    public YatzyCalculator() {
        RaffleCup raffleCup = new RaffleCup();
        int[] eyes = raffleCup.rollDice();
        for (int eye : eyes) {
            eyesDistribution[eye - 1]++;
        }
    }

    public int calculateOnePairs() {
        for (int index = 0; index < 6; index++) {
            if (eyesDistribution[index] >= 2) {
                return 2 * (index + 1);
            }
        }
        return 0;
    }

    public int calculateThreeOfAKind() {
        for (int index = 0; index < 6; index++) {
            if (eyesDistribution[index] >= 3) {
                return 3 * (index + 1);
            }
        }
        return 0;
    }
}
