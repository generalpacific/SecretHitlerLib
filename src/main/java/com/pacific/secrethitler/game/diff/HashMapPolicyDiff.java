package com.pacific.secrethitler.game.diff;

import com.pacific.secrethitler.types.Policy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HashMap based approach to get the discarded policy.
 */
public class HashMapPolicyDiff implements PolicyDiff {


    @Override
    public Policy getDiscardedPolicy(List<Policy> policies1, List<Policy>
            policies2) {
        final int policies2Size = policies2.size();
        final int policies1Size = policies1.size();
        if (Math.abs(policies1Size - policies2Size) != 1) {
            throw new IllegalArgumentException("The difference between the "
                    + "size of policies should be equal to 1");
        }
        final List<Policy> largerList = policies1Size > policies2Size ?
                policies1 : policies2;
        final List<Policy> smallerList = policies1Size > policies2Size ?
                policies2 : policies1;
        final Map<Policy, Integer> map = new HashMap<>();
        for (final Policy policy : largerList) {
            Integer count = map.get(policy);
            if (count == null) {
                count = 1;
            } else {
                count = count + 1;
            }
            map.put(policy, count);
        }
        for (final Policy policy : smallerList) {
            Integer count = map.get(policy);
            if (count == null) {
                continue;
            }
            count--;
            if (count == 0) {
                map.remove(policy);
            } else {
                map.put(policy, count);
            }
        }
        return (Policy) map.keySet().toArray()[0];
    }
}
