package edu.unac;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private Dice dice;
    private int minToWin;

    public boolean play(){
        int result = dice.roll();
        System.out.println("Roll result: " + result);
        return result >= minToWin;
    }
}
