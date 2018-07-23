package com.manzano.service;

import com.manzano.data.Choice;
import com.manzano.data.Player;
import com.manzano.service.impl.StatisticsManagerServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StatisticsManagerServiceTest {

    private StatisticsManagerService service;

    private List<Player> players;

    @Before
    public void setup() {
        service = new StatisticsManagerServiceImpl();

        players = new ArrayList<>();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2", Choice.PAPER);
        players.add(player1);
        players.add(player2);
    }

    @Test
    public void testAddRoundToStatistics(){
        assertTrue(service.getResultsPerRoundAtAppScope().isEmpty());
        service.addRoundToStatistics(players);
        assertFalse(service.getResultsPerRoundAtAppScope().isEmpty());
        assertThat(service.getResultsPerRoundAtAppScope().size(), is(equalTo(1)));
    }
}
