package com.pacific.secrethitler.game.diff;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import static com.pacific.secrethitler.types.Policy.FASCIST;
import static com.pacific.secrethitler.types.Policy.LIBERAL;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HashMapPolicyDiffTest {

    @Test
    public void testPolicyDiff() {
        final PolicyDiff policyDiff = new HashMapPolicyDiff();

        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(FASCIST,
                FASCIST, FASCIST), ImmutableList.of(FASCIST, FASCIST)), is
                (FASCIST));
        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(FASCIST,
                FASCIST), ImmutableList.of(FASCIST, FASCIST, FASCIST)), is
                (FASCIST));

        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(FASCIST,
                FASCIST, LIBERAL), ImmutableList.of(FASCIST, LIBERAL)), is
                (FASCIST));
        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(FASCIST,
                LIBERAL), ImmutableList.of(FASCIST, FASCIST, LIBERAL)), is
                (FASCIST));

        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                LIBERAL, LIBERAL), ImmutableList.of(LIBERAL, LIBERAL)), is
                (LIBERAL));
        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                LIBERAL), ImmutableList.of(LIBERAL, LIBERAL, LIBERAL)), is
                (LIBERAL));

        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                LIBERAL, FASCIST), ImmutableList.of(LIBERAL, LIBERAL)), is
                (FASCIST));
        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                LIBERAL), ImmutableList.of(LIBERAL, LIBERAL, FASCIST)), is
                (FASCIST));

        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                LIBERAL, FASCIST), ImmutableList.of(LIBERAL, FASCIST)), is
                (LIBERAL));
        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                FASCIST), ImmutableList.of(LIBERAL, LIBERAL, FASCIST)), is
                (LIBERAL));

        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                LIBERAL), ImmutableList.of(LIBERAL)), is
                (LIBERAL));
        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL),
                ImmutableList.of(LIBERAL, LIBERAL)), is(LIBERAL));

        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL,
                FASCIST), ImmutableList.of(LIBERAL)), is
                (FASCIST));
        assertThat(policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL),
                ImmutableList.of(LIBERAL, FASCIST)), is(FASCIST));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testError() {
        final PolicyDiff policyDiff = new HashMapPolicyDiff();
        policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL, LIBERAL),
                ImmutableList.of(LIBERAL, FASCIST));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testError2() {
        final PolicyDiff policyDiff = new HashMapPolicyDiff();
        policyDiff.getDiscardedPolicy(ImmutableList.of(LIBERAL, LIBERAL,
                FASCIST, FASCIST), ImmutableList.of(LIBERAL, FASCIST));
    }
}
