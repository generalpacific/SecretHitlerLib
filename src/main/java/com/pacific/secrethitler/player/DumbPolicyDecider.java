package com.pacific.secrethitler.player;

import com.google.common.collect.ImmutableList;

import com.pacific.secrethitler.types.Policy;

import java.util.List;

/**
 * Returns first policies
 */
public class DumbPolicyDecider implements PolicyDecider {
    @Override
    public List<Policy> decidePolicyToSendtoChancellor(Policy policy1, Policy
            policy2, Policy policy3) {
        return ImmutableList.of(policy1, policy2);
    }

    @Override
    public Policy decidePolicyToEnact(Policy policy1, Policy policy2) {
        return policy1;
    }
}
