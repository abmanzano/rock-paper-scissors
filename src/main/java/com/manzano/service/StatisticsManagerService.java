package com.manzano.service;

import com.manzano.data.Player;

import java.util.List;
import java.util.Map;

public interface StatisticsManagerService {

    void addRoundToStatistics(List<Player> players);

    Map<Integer, List<Player>> getResultsPerRoundAtAppScope();
}
