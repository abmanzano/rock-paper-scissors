package com.manzano.util;

import com.manzano.data.Choice;
import com.manzano.data.Player;
import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.*;

public class GameUtilsTest {

    GameUtils utils = new GameUtils();

    @Test
    public void testRandomChoice() {
        Choice result;
        EnumSet<Choice> choiceEnumSet = EnumSet.of(Choice.ROCK, Choice.PAPER, Choice.SCISSORS);

        for (int i = 0; i < 10; i++) {
            result = utils.randomChoice();
            assertNotNull(result);
            assertTrue(choiceEnumSet.contains(result));
        }
    }

    @Test
    public void testEvaluatePlay() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2", Choice.PAPER);

        utils.evaluatePlay(player1, player2);
        assertFalse(player1.hasWon());
        assertTrue(player2.hasWon());

        player2 = new Player("Player 2", Choice.SCISSORS);

        utils.evaluatePlay(player1, player2);
        assertTrue(player1.hasWon());
        assertFalse(player2.hasWon());
    }

}
