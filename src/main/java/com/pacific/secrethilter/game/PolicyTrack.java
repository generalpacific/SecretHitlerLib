package com.pacific.secrethilter.game;

/**
 * Policy track that maintains the policies enacted for the current track.
 *
 * @author prashantchaudhary
 */
public class PolicyTrack {
    private int numOfPoliciesEnacted;

    private PolicyTrack() {
        numOfPoliciesEnacted = 0;
    }

    public static PolicyTrack newPolicyTrack() {
        return new PolicyTrack();
    }

    public int getNumberOfPoliciesEnacted() {
        return numOfPoliciesEnacted;
    }

    public void enactPolicy() {
        numOfPoliciesEnacted++;
    }

    @Override
    public String toString() {
        return "PolicyTrack{" + "numOfPoliciesEnacted=" +
                numOfPoliciesEnacted + '}';
    }
}
