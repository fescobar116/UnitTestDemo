package edu.unac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Dice dice;
    @BeforeEach
    void setUp() {
        this.dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(5);
    }

    @Test
    public void playerWins() {
        Player player = new Player(dice, 4);
        Assertions.assertTrue(player.play());
    }

    @Test
    public void playerLoses() {
        Player player = new Player(dice, 6);
        Assertions.assertFalse(player.play());
    }
}