package com.pacific.secrethitler.game.diff;

import com.pacific.secrethitler.types.Policy;

import java.util.List;

/**
 * Interface for policy diff operation.
 */
public interface PolicyDiff {
    Policy getDiscardedPolicy(final List<Policy> policies1, final
    List<Policy> policies2);
}
