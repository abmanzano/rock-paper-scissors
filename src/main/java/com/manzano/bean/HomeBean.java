package com.manzano.bean;

import com.manzano.data.Player;
import com.manzano.service.PlayRoundService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ManagedBean
@SessionScoped
public class HomeBean implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(HomeBean.class);

    @Inject
    private PlayRoundService playRoundService;

    private int round = 0;
    private Map<Integer, List<Player>> resultsPerRound = new HashMap<>();

    public HomeBean() {

    }

    public void playGame() {
        round++;

        List<Player> players = playRoundService.playRandomRound();
        resultsPerRound.put(round, players);

        LOGGER.info("Player plays round number " + round);
    }

    public void restartGame() {
        round = 0;
        resultsPerRound = new HashMap<>();

        LOGGER.info("Restart game for current player.");
    }

    public int getRound() {
        return round;
    }

    public Map<Integer, List<Player>> getResultsPerRound() {
        return resultsPerRound;
    }
}