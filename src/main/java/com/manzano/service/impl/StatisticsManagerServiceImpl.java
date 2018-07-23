package com.manzano.service.impl;

import com.manzano.data.Player;
import com.manzano.service.StatisticsManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Singleton
public class StatisticsManagerServiceImpl implements StatisticsManagerService {

    private static final Logger LOGGER = LogManager.getLogger(StatisticsManagerServiceImpl.class);

    private int roundAtAppScope = 0;

    private Map<Integer, List<Player>> resultsPerRoundAtAppScope = new HashMap<>();

    @Override
    public void addRoundToStatistics(List<Player> players) {
        roundAtAppScope++;
        resultsPerRoundAtAppScope.put(roundAtAppScope, players);

        LOGGER.info(String.format("Round %s added to the statistics ", roundAtAppScope));
    }

    public Map<Integer, List<Player>> getResultsPerRoundAtAppScope() {
        return resultsPerRoundAtAppScope;
    }
}
