package com.pacific.secrethilter.player;

import java.util.List;

import com.google.common.collect.ImmutableList;

import com.pacific.secrethilter.types.Policy;
import com.pacific.secrethilter.types.Position;
import com.pacific.secrethilter.types.Role;
import com.pacific.secrethilter.types.Vote;

/**
 * This is the player class that holds the state for the player.
 *
 * @author prashantchaudhary
 */
public class Player implements VoteCaster, PolicyDecider {

    private final String playerId;
    private final Role role;


    private Player(String playerId, Role role) {
        this.playerId = playerId;
        this.role = role;
    }

    public Player newPlayer(String playerId, Role role) {
        return new Player(playerId, role);
    }

    @Override
    public Vote castVote(String playerId, Position position) {
        // TODO Add logic
        return Vote.YES;
    }

    @Override
    public List<Policy> decidePolicy(Policy policy1, Policy policy2,
                                     Policy policy3) {
        // TODO Add logic
        return ImmutableList.of(policy1, policy2);
    }

    @Override
    public Policy decidePolicy(Policy policy1, Policy policy2) {
        // TODO Add logic
        return policy1;
    }

    public String getPlayerId() {
        return  playerId;
    }
}
