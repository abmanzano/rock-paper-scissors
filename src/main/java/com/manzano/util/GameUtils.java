package com.manzano.util;

import java.util.Random;

import com.manzano.data.Choice;
import com.manzano.data.Player;

public class GameUtils {

    public static Choice randomChoice() {
        Random random = new Random();
        int randomChoice = random.nextInt(3);

        switch (randomChoice) {
            case 0:
                return Choice.ROCK;
            case 1:
                return Choice.PAPER;
            default:
                return Choice.SCISSORS;
        }
    }

    public static void evaluatePlay(Player player1, Player player2) {
        if ((player1.getChoice() == Choice.ROCK && player2.getChoice() == Choice.SCISSORS)
                || (player1.getChoice() == Choice.PAPER && player2.getChoice() == Choice.ROCK)
                || (player1.getChoice() == Choice.SCISSORS && player2.getChoice() == Choice.PAPER)) {
            player1.setWins(true);
        } else if (player1.getChoice() != player2.getChoice()) {
            player2.setWins(true);
        }
    }
}
