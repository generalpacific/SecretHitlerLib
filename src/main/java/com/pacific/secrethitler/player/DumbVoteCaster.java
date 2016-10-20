package com.pacific.secrethitler.player;

import com.pacific.secrethitler.types.Position;
import com.pacific.secrethitler.types.Vote;

/**
 * Dumb vote caster always returns YES.
 */
public class DumbVoteCaster implements VoteCaster {
    @Override
    public Vote castVote(String playerId, Position position) {
        return Vote.YES;
    }
}
