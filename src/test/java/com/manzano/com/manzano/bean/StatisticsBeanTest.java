package com.manzano.com.manzano.bean;

import com.manzano.bean.StatisticsBean;
import com.manzano.data.Choice;
import com.manzano.data.Player;
import com.manzano.service.StatisticsManagerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsBeanTest {

    @InjectMocks
    private StatisticsBean managedBean;

    @Mock
    private StatisticsManagerService service;

    private Map<Integer, List<Player>> resultsPerRoundAtAppScope;

    @Before
    public void setup() {
        resultsPerRoundAtAppScope = provideResultMap();
    }

    @Test
    public void testDisplayStatistics() {
        Mockito.when(service.getResultsPerRoundAtAppScope()).thenReturn(resultsPerRoundAtAppScope);
        managedBean.displayStatistics();

        assertThat(managedBean.getTotalRounds(), is(equalTo(5)));
        assertThat(managedBean.getTotalWinsFirstPlayer(), is(equalTo(0)));
        assertThat(managedBean.getTotalWinsSecondPlayer(), is(equalTo(5)));
        assertThat(managedBean.getTotalDraws(), is(equalTo(0)));
    }

    private Map<Integer, List<Player>> provideResultMap() {
        Map<Integer, List<Player>> resultsPerRoundAtAppScope = new HashMap<>();

        for (int i = 1; i < 6; i++) {
            List<Player> players = new ArrayList<>();
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2", Choice.PAPER);
            players.add(player1);
            players.add(player2);
            players.get(1).setWins(true);
            resultsPerRoundAtAppScope.put(i, players);
        }

        return resultsPerRoundAtAppScope;
    }
}
