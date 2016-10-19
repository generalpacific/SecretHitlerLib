package com.pacific.secrethitler;

import com.pacific.secrethitler.condition.RoundResult;
import com.pacific.secrethitler.test.TestData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test class that has main method that simulates the Runner.
 */
public class MainTest {

    private static final Logger logger = LoggerFactory.getLogger(MainTest
            .class.getSimpleName());

    public static void main(String[] args) {
        final TestData testData = new TestData();
        final GameRunner gameRunner = GameRunner.newGameRunner(testData
                .getInitialPolicies(), testData.getInitialPlayers(), testData
                .getFirstPresident());

        int i = 0;
        RoundResult result = RoundResult.CONTINUE_GAME;
        while (result.equals(RoundResult.CONTINUE_GAME)) {
            logger.info("Running round: " + i);
            result = gameRunner.runRound();
            logger.info("Round: " + i + " result: " + result);
            ++i;
        }
    }
}
