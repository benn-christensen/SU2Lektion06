package exercise02.models;

public class RaffleCup {
    private Die[] dice = new Die[5];

    public RaffleCup() {
        for (int index = 0; index < dice.length; index++) {
            dice[index] = new Die();
        }
    }

    public int[] rollDice() {
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            result[i] = dice[i].roll();
        }
        return result;
    }
}
