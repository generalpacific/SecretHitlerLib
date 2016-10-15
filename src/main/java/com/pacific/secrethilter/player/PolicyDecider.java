package com.pacific.secrethilter.player;

import java.util.List;

import com.pacific.secrethilter.types.Policy;

/**
 * Interface for policy decider.
 *
 * @author prashantchaudhary
 */
public interface PolicyDecider {

    /**
     * Decides the 2 policies to send to the Chancellor.
     */
    List<Policy> decidePolicyToSendtoChancellor(Policy policy1, Policy policy2, Policy policy3);

    /**
     * Decide the policy to implement.
     */
    Policy decidePolicyToEnact(Policy policy1, Policy policy2);
}
