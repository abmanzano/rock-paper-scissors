package com.manzano.service;

import com.manzano.data.Player;

import java.util.List;

public interface PlayRound {

    /**
     * There will be 2 kind of players. One should always choose randomly, the
     * other should always choose rock.
     */
    List<Player> playRandomRound();
}
