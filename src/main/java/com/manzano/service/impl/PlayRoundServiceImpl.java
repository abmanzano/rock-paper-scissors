package com.manzano.service.impl;

import com.manzano.aop.GameStatistics;
import com.manzano.data.Player;
import com.manzano.service.PlayRoundService;
import com.manzano.util.GameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayRoundServiceImpl implements PlayRoundService, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(PlayRoundServiceImpl.class);

    @GameStatistics
    @Override
    public List<Player> playRandomRound() {
        LOGGER.info("Service returns two players. One always choosing randomly and the other always choosing rock.");

        List<Player> players = new ArrayList<>();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2", GameUtils.randomChoice());

        GameUtils.evaluatePlay(player1, player2);
        players.add(player1);
        players.add(player2);

        LOGGER.debug(String.format("Status of players after playing new round: \n Player %s choice was %s. \n Player %s choice was %s.",
                players.get(0).getPlayerName(), players.get(0).getChoice().getChoiceDescription(),
                players.get(1).getPlayerName(), players.get(1).getChoice().getChoiceDescription()));

        return players;
    }

}
