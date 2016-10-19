package com.pacific.secrethitler.condition;

import com.pacific.secrethitler.game.GameState;

/**
 * Checks the game condition based on the
 * {@link com.pacific.secrethitler.game.GameState}
 */
public class ConditionsChecker {

    private ConditionsChecker() {

    }

    public static RoundResult checkCondition(final GameState gameState) {

        if (gameState.getNumberOfEnactedFascistPolicies() == 6) {
            return RoundResult.FASCIST_WON;
        } else if (gameState.getNumberOfEnactedLiberalPolicies() == 5) {
            return RoundResult.LIBERAL_WON;
        }
        return RoundResult.CONTINUE_GAME;
    }
}
