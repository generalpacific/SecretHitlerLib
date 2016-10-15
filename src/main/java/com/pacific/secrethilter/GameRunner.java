package com.pacific.secrethilter;

import com.pacific.secrethilter.game.GameState;
import com.pacific.secrethilter.game.Government;
import com.pacific.secrethilter.player.Player;
import com.pacific.secrethilter.types.Policy;
import com.pacific.secrethilter.types.Position;

import java.util.List;

/**
 * This is the core class that runs the game.
 *
 * @author prashantchaudhary
 */
public class GameRunner {

    private final GameState gameState;

    private GameRunner(List<Policy> initialShuffledPolicies, List<Player> players, Player firstPresident) {
        this.gameState = GameState.newGameState(initialShuffledPolicies, players, firstPresident);
    }

    public GameRunner newGameRunner(List<Policy> initialShuffledPolicies, List<Player> players, Player firstPresident) {
        return new GameRunner(initialShuffledPolicies, players, firstPresident);
    }

    public void runRound() {

        final Player nextPresident = gameState.getNextPresident();

        final Player chancellor = nextPresident.selectChancellor();

        for (final Player player : gameState.getPlayers()) {
            if (player.equals(chancellor)) {
                continue;
            }
            player.castVote(chancellor.getPlayerId(), Position.CHANCELLOR);
        }

        gameState.setCurrentGovernment(Government.newGovernment(nextPresident, chancellor));

        final Policy policy1 = gameState.drawPolicy();
        final Policy policy2 = gameState.drawPolicy();
        final Policy policy3 = gameState.drawPolicy();

        final List<Policy> policies = gameState.getCurrentGovernment().getPresident().decidePolicyToSendtoChancellor(policy1, policy2, policy3);

        final Policy policy = gameState.getCurrentGovernment().getChancellor().decidePolicyToEnact(policies.get(0), policies.get(1));

        gameState.enactPolicy(policy);
    }
}
