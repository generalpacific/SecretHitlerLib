package com.pacific.secrethitler.player;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import com.pacific.secrethitler.game.GameState;
import com.pacific.secrethitler.game.Government;
import com.pacific.secrethitler.types.Policy;
import com.pacific.secrethitler.types.Position;
import com.pacific.secrethitler.types.Role;
import com.pacific.secrethitler.types.Vote;

/**
 * This is the player class that holds the state for the player.
 *
 * @author prashantchaudhary
 */
public class Player implements VoteCaster, PolicyDecider, ChancellorDecider {

    private final String playerId;
    private final Role role;
    private final VoteCaster voteCaster;
    private final PolicyDecider policyDecider;

    private Player(String playerId, Role role, VoteCaster voteCaster,
                   PolicyDecider policyDecider) {
        this.playerId = playerId;
        this.role = role;
        this.voteCaster = voteCaster;
        this.policyDecider = policyDecider;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Vote castVote(String playerId, Position position) {
        return voteCaster.castVote(playerId, position);
    }

    @Override
    public List<Policy> decidePolicyToSendtoChancellor(Policy policy1, Policy
            policy2, Policy policy3) {
        return policyDecider.decidePolicyToSendtoChancellor(policy1, policy2,
                policy3);
    }

    @Override
    public Policy decidePolicyToEnact(Policy policy1, Policy policy2) {
        return policyDecider.decidePolicyToEnact(policy1, policy2);
    }

    public String getPlayerId() {
        return playerId;
    }

    @Override
    public Player selectChancellor(final GameState gameState) {
        final List<Player> players = gameState.getPlayers();
        final Government lastGovernment = gameState.getLastGovernment();
        for (final Player player : players) {
            String playerId = player.getPlayerId();
            if (isCurrentOrLastChancellorOrLastPresident(lastGovernment,
                    playerId)) {
                continue;
            }
            return player;
        }
        return null;
    }

    private boolean isCurrentOrLastChancellorOrLastPresident(Government
                                                                     lastGovernment, String playerId) {
        if (playerId.equals(getPlayerId())) {
            return true;
        }
        if (lastGovernment == null) {
            return false;
        }
        return playerId.equals(lastGovernment.getChancellor().getPlayerId())
                || playerId.equals(lastGovernment.getPresident());
    }

    @Override
    public String toString() {
        return "Player{" + "playerId='" + playerId + '\'' + ", role=" + role
                + '}';
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

    public static class Builder {
        private String playerId;
        private Role role;
        private VoteCaster voteCaster = new DumbVoteCaster();
        private PolicyDecider policyDecider = new DumbPolicyDecider();

        private Builder() {

        }

        public Builder setPlayerId(String playerId) {
            this.playerId = playerId;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setVoteCaster(VoteCaster voteCaster) {
            this.voteCaster = voteCaster;
            return this;
        }

        public Builder setPolicyDecider(PolicyDecider policyDecider) {
            this.policyDecider = policyDecider;
            return this;
        }

        public Player build() {
            return new Player(playerId, role, voteCaster, policyDecider);
        }
    }
}
