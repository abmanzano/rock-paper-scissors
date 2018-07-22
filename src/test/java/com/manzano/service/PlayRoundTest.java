package com.manzano.service;

import com.manzano.data.Player;
import com.manzano.service.impl.PlayRoundImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayRoundTest {

    PlayRound service;

    @Before
    public void setup() {
        service = new PlayRoundImpl();
    }

    @Test
    public void testPlayRandomRound() {
        List<Player> result = new ArrayList<>();

        assertTrue(result.isEmpty());
        result = service.playRandomRound();
        assertFalse(result.isEmpty());
        assertTrue(result.size() == 2);
    }
}
