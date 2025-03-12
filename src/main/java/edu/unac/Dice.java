package edu.unac;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Dice {
    private int sides;

    public int roll(){
        return new Random().nextInt(sides) + 1;
    }
}
