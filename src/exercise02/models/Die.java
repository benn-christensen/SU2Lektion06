package exercise02.models;

import java.util.Random;

public class Die {
    private Random random = new Random();
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
