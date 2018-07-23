package com.manzano.bean;

import com.manzano.data.Player;
import com.manzano.service.StatisticsManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ManagedBean
public class StatisticsBean implements Serializable {

    private static final Logger LOGGER = LogManager.getLogger(StatisticsBean.class);

    @Inject
    private StatisticsManagerService statisticsManagerService;

    private int totalRounds;
    private int totalWinsFirstPlayer;
    private int totalWinsSecondPlayer;
    private int totalDraws;

    public StatisticsBean() {

    }

    public void displayStatistics() {
        LOGGER.info("Commencing statistics generation.");

        Map<Integer, List<Player>> resultsPerRoundAtAppScope = statisticsManagerService.getResultsPerRoundAtAppScope();

        totalRounds = resultsPerRoundAtAppScope.keySet().stream().max(Integer::compareTo).orElse(0);

        resultsPerRoundAtAppScope.forEach((k, v) -> {
            if (v.get(0).hasWon()) {
                totalWinsFirstPlayer++;
            } else if (v.get(1).hasWon()) {
                totalWinsSecondPlayer++;
            }
        });

        totalDraws = totalRounds - totalWinsFirstPlayer - totalWinsSecondPlayer;

        LOGGER.debug(String.format("Results of all the rounds since application was deployed. Total rounds: %d, " +
                        "total wins for first players: %d, total wins for second players: %d, total draws: %d ", totalRounds,
                totalWinsFirstPlayer, totalWinsSecondPlayer, totalDraws));
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getTotalWinsFirstPlayer() {
        return totalWinsFirstPlayer;
    }

    public int getTotalWinsSecondPlayer() {
        return totalWinsSecondPlayer;
    }

    public int getTotalDraws() {
        return totalDraws;
    }
}
