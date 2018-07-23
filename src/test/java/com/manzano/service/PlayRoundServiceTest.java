package com.manzano.service;

import com.manzano.data.Player;
import com.manzano.service.impl.PlayRoundServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlayRoundServiceTest {

    private PlayRoundService service;

    @Before
    public void setup() {
        service = new PlayRoundServiceImpl();
    }

    @Test
    public void testPlayRandomRound() {
        List<Player> result = new ArrayList<>();

        assertTrue(result.isEmpty());
        result = service.playRandomRound();
        assertFalse(result.isEmpty());
        assertThat(result.size(), is(equalTo(2)));
    }
}
