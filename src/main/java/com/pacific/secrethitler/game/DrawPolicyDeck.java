package com.pacific.secrethitler.game;

import com.pacific.secrethitler.types.Policy;

/**
 * Interface for draw policy deck.
 *
 * @author prashantchaudhary
 */
public interface DrawPolicyDeck {

    /**
     * Draws the policy from the deck.
     */
    Policy drawPolicy();

    /**
     * Puts back the policy at the bottom of the deck.
     */
    void putDiscardedPolicy(Policy policy);
}
