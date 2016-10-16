package com.pacific.secrethilter.player;

import com.pacific.secrethilter.game.GameState;

/**
 * Interface for selecting the chancellor
 */
public interface ChancellorDecider {
    Player selectChancellor(final GameState gameState);
}
