package com.pacific.secrethilter;

import com.pacific.secrethilter.game.GameState;
import com.pacific.secrethilter.player.Player;
import com.pacific.secrethilter.types.Policy;

import java.util.List;
import java.util.Set;

/**
 * This is the core class that runs the game.
 *
 * @author prashantchaudhary
 */
public class GameRunner {

    private final int numOfPlayers;
    private final Set<Player> players;
    private final GameState gameState;

    private GameRunner(List<Policy> initialShuffledPolicies, Set<Player> players) {
        this.numOfPlayers = players.size();
        this.players = players;
        this.gameState = GameState.newGameState(initialShuffledPolicies, players);
    }

    public GameRunner newGameRunner(List<Policy> initialShuffledPolicies, Set<Player> players) {
        return new GameRunner(initialShuffledPolicies, players);
    }
}
