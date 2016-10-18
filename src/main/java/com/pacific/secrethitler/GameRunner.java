package com.pacific.secrethitler;

import com.google.common.collect.ImmutableList;

import com.pacific.secrethitler.game.GameState;
import com.pacific.secrethitler.game.Government;
import com.pacific.secrethitler.game.diff.HashMapPolicyDiff;
import com.pacific.secrethitler.game.diff.PolicyDiff;
import com.pacific.secrethitler.player.Player;
import com.pacific.secrethitler.types.Policy;
import com.pacific.secrethitler.types.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * This is the core class that runs the game.
 *
 * @author prashantchaudhary
 */
public class GameRunner {

    private static final Logger logger = LoggerFactory.getLogger(GameRunner
            .class.getSimpleName());
    private static final PolicyDiff policyDiff = new HashMapPolicyDiff();

    private final GameState gameState;

    private GameRunner(List<Policy> initialShuffledPolicies, List<Player>
            players, Player firstPresident) {
        this.gameState = GameState.newGameState(initialShuffledPolicies,
                players, firstPresident);
    }

    public static GameRunner newGameRunner(List<Policy>
                                                   initialShuffledPolicies,
                                           List<Player> players, Player
                                                   firstPresident) {
        return new GameRunner(initialShuffledPolicies, players, firstPresident);
    }

    public void runRound() {

        logger.info("GameState before round: " + gameState);

        final Player nextPresident = gameState.getNextPresident();

        final Player chancellor = nextPresident.selectChancellor(gameState);

        for (final Player player : gameState.getPlayers()) {
            if (player.equals(chancellor)) {
                continue;
            }
            player.castVote(chancellor.getPlayerId(), Position.CHANCELLOR);
        }

        final Government government = Government.newGovernment(nextPresident,
                chancellor);
        gameState.setCurrentGovernment(government);

        final Policy policy1 = gameState.drawPolicy();
        final Policy policy2 = gameState.drawPolicy();
        final Policy policy3 = gameState.drawPolicy();
        final ImmutableList<Policy> initialPolicies = ImmutableList.of
                (policy1, policy2, policy3);

        final List<Policy> policies = gameState.getCurrentGovernment()
                .getPresident().decidePolicyToSendtoChancellor(policy1,
                        policy2, policy3);
        gameState.putDiscardedPolicy(policyDiff.getDiscardedPolicy
                (initialPolicies, policies));

        final Policy policy = gameState.getCurrentGovernment().getChancellor
                ().decidePolicyToEnact(policies.get(0), policies.get(1));
        gameState.putDiscardedPolicy(policyDiff.getDiscardedPolicy
                (ImmutableList.of(policy), policies));

        gameState.enactPolicy(policy);
        gameState.setLastGovernment(government);
        logger.info("GameState after round: " + gameState);

    }
}
