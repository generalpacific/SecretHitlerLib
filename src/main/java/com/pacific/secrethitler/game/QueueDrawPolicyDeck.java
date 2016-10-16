package com.pacific.secrethitler.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.pacific.secrethitler.types.Policy;

/**
 * The class represents the draw policy deck that contains the policies which
 * players can draw the policies during each round.
 *
 * @author prashantchaudhary
 */
public class QueueDrawPolicyDeck implements DrawPolicyDeck {

    private final Queue<Policy> deck;

    private QueueDrawPolicyDeck(final List<Policy> initialShuffledPolicies) {
        deck = new LinkedList<Policy>(initialShuffledPolicies);
    }

    /**
     * Create an instance of the initial policy deck.
     */
    public static QueueDrawPolicyDeck newDrawPolicyDeck(final List<Policy>
                                                                initialShuffledPolicies) {
        return new QueueDrawPolicyDeck(initialShuffledPolicies);
    }

    /**
     * Returns a policy from the top of the deck.
     */
    @Override
    public Policy drawPolicy() {
        return deck.poll();
    }

    /**
     * Puts a discarded policy at the bottom up the deck.
     */
    @Override
    public void putDiscardedPolicy(final Policy policy) {
        deck.add(policy);
    }
}
