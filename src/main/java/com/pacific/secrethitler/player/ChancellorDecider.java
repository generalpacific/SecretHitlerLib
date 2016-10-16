package com.pacific.secrethitler.player;

import com.pacific.secrethitler.game.GameState;

/**
 * Interface for selecting the chancellor
 */
public interface ChancellorDecider {
    Player selectChancellor(final GameState gameState);
}
