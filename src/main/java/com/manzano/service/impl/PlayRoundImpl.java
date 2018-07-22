package com.manzano.service.impl;

import com.manzano.data.Player;
import com.manzano.service.PlayRound;
import com.manzano.util.GameUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayRoundImpl implements PlayRound, Serializable {

    @Override
    public List<Player> playRandomRound() {
        List<Player> players = new ArrayList<>();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2", GameUtils.randomChoice());

        GameUtils.evaluatePlay(player1, player2);
        players.add(player1);
        players.add(player2);

        return players;
    }

}
