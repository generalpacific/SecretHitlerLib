package com.pacific.secrethilter;

import com.pacific.secrethilter.test.TestData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test class that has main method that simulates the Runner.
 */
public class MainTest {

    private static final Logger logger = LoggerFactory.getLogger(MainTest.class.getSimpleName());

    public static void main(String[] args) {
        final TestData testData = new TestData();
        final GameRunner gameRunner = GameRunner.newGameRunner(testData.getInitialPolicies(), testData.getInitialPlayers(), testData.getFirstPresident());

        logger.info("Running round 1");
        gameRunner.runRound();
    }
}
