package com.manzano.com.manzano.bean;


import com.manzano.bean.HomeBean;
import com.manzano.data.Choice;
import com.manzano.data.Player;
import com.manzano.service.PlayRound;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HomeBeanTest {

    @InjectMocks
    HomeBean managedBean;

    @Mock
    PlayRound playRoundService;

    List<Player> players;

    @Before
    public void setup() {
        players = new ArrayList<>();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2", Choice.PAPER);
        players.add(player1);
        players.add(player2);
    }

    @Test
    public void testPlayGame() {
        assertTrue(managedBean.getRound() == 0);
        assertTrue(managedBean.getResultsPerRound().isEmpty());

        Mockito.when(playRoundService.playRandomRound()).thenReturn(players);
        managedBean.playGame();
        Mockito.verify(playRoundService).playRandomRound();
        assertTrue(managedBean.getRound() == 1);
        assertFalse(managedBean.getResultsPerRound().isEmpty());
    }

    @Test
    public void testRestartGame() {
        Mockito.when(playRoundService.playRandomRound()).thenReturn(players);
        managedBean.playGame();
        Mockito.verify(playRoundService).playRandomRound();
        assertTrue(managedBean.getRound() == 1);
        assertFalse(managedBean.getResultsPerRound().isEmpty());

        managedBean.restartGame();
        assertTrue(managedBean.getRound() == 0);
        assertTrue(managedBean.getResultsPerRound().isEmpty());
    }
}
