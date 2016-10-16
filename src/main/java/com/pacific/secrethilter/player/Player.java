package com.pacific.secrethilter.player;

import java.util.List;
import java.util.Random;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import com.pacific.secrethilter.game.GameState;
import com.pacific.secrethilter.game.Government;
import com.pacific.secrethilter.types.Policy;
import com.pacific.secrethilter.types.Position;
import com.pacific.secrethilter.types.Role;
import com.pacific.secrethilter.types.Vote;

/**
 * This is the player class that holds the state for the player.
 *
 * @author prashantchaudhary
 */
public class Player implements VoteCaster, PolicyDecider, ChancellorDecider {

    private final String playerId;
    private final Role role;

    private Player(String playerId, Role role) {
        this.playerId = playerId;
        this.role = role;
    }

    public static Player newPlayer(String playerId, Role role) {
        return new Player(playerId, role);
    }

    @Override
    public Vote castVote(String playerId, Position position) {
        // TODO Add logic
        return Vote.YES;
    }

    @Override
    public List<Policy> decidePolicyToSendtoChancellor(Policy policy1, Policy policy2,
                                            Policy policy3) {
        // TODO Add logic
        return ImmutableList.of(policy1, policy2);
    }

    @Override
    public Policy decidePolicyToEnact(Policy policy1, Policy policy2) {
        // TODO Add logic
        return policy1;
    }

    public String getPlayerId() {
        return  playerId;
    }

    @Override
    public Player selectChancellor(final GameState gameState) {
        final List<Player> players = gameState.getPlayers();
        final Government lastGovernment = gameState.getLastGovernment();
        for (final Player player : players) {
            String playerId = player.getPlayerId();
            if (isCurrentOrLastChancellorOrLastPresident(lastGovernment, playerId)) {
                continue;
            }
            return player;
        }
        return null;
    }

    private boolean isCurrentOrLastChancellorOrLastPresident(Government lastGovernment, String playerId) {
        if (playerId.equals(getPlayerId())) {
            return true;
        }
        if (lastGovernment == null) {
            return false;
        }
        return playerId.equals(lastGovernment.getChancellor().getPlayerId()) || playerId.equals(lastGovernment.getPresident());
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equal(playerId, player.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(playerId);
    }
}
