package com.pacific.secrethitler.game.shuffle;

import java.util.List;

import com.pacific.secrethitler.types.Policy;

/**
 * Takes a list of policies and returns the list of shuffled policies.
 *
 * @author prashantchaudhary
 */
public interface Shuffler {

    List<Policy> shuffle(List<Policy> policies);

}
