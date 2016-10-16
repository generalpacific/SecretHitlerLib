package com.pacific.secrethilter.game;

import com.pacific.secrethilter.player.Player;

/**
 * Government class that consists of president and chancellor.
 */
public class Government {
    private final Player president;
    private final Player chancellor;

    private Government(final Player president, final Player chancellor) {
        this.president = president;
        this.chancellor = chancellor;
    }

    public static Government newGovernment(final Player president, final
    Player chancellor) {
        return new Government(president, chancellor);
    }

    public Player getPresident() {
        return president;
    }

    public Player getChancellor() {
        return chancellor;
    }

    @Override
    public String toString() {
        return "Government{" + "president=" + president + ", chancellor=" +
                chancellor + '}';
    }
}
