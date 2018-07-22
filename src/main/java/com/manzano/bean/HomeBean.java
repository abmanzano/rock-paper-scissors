package com.manzano.bean;

import com.manzano.data.Player;
import com.manzano.service.PlayRound;

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

    @Inject
    private PlayRound playRound;

    private int round = 0;
    private Map<Integer, List<Player>> resultsPerRound = new HashMap<>();

    public HomeBean() {

    }

    public void playGame() {
        round++;

        List<Player> players = playRound.playRandomRound();
        resultsPerRound.put(round, players);
    }

    public void restartGame(){
        round = 0;
        resultsPerRound = new HashMap<>();
    }

    public int getRound() {
        return round;
    }

    public Map<Integer, List<Player>> getResultsPerRound() {
        return resultsPerRound;
    }
}