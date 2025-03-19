package edu.unac;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random = new Random();
    public int generate() {
        return random.nextInt();
    }
}
