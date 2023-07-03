package game;

import java.util.Random;

class Dice {
    private int sides=6;
    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        int rate = random.nextInt(100) + 1;
        int point = 1;
        if (rate <= 80) {
            point = 2;
        }
        if (rate <= 64) {
            point = 3;
        }
        if (rate <= 48) {
            point = 4;
        }
        if (rate <= 32) {
            point = 5;
        }
        if (rate <= 16) {
            point = 6;
        }
        return point;
    }
}
