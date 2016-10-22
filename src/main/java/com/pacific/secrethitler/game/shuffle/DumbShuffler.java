package com.pacific.secrethitler.game.shuffle;

import java.util.List;

/**
 * This shuffler just returns the passed list back.
 */
public class DumbShuffler implements Shuffler<Object> {
    @Override
    public List<Object> shuffle(List<Object> policies) {
        return policies;
    }
}
