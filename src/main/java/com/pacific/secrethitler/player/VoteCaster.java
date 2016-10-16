package com.pacific.secrethitler.player;

import com.pacific.secrethitler.types.Position;
import com.pacific.secrethitler.types.Vote;

public interface VoteCaster {

    /**
     * Returns the vote for the player with playerId for position.
     */
    Vote castVote(String playerId, Position position);
}
