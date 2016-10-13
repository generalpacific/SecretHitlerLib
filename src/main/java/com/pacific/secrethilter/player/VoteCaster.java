package com.pacific.secrethilter.player;

import com.pacific.secrethilter.types.Position;
import com.pacific.secrethilter.types.Vote;

public interface VoteCaster {

    /**
     * Returns the vote for the player with playerId for position.
     */
    Vote castVote(String playerId, Position position);
}
