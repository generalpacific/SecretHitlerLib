package com.pacific.secrethitler;

import com.pacific.secrethitler.condition.RoundResult;
import com.pacific.secrethitler.game.shuffle.CollectionsShuffler;
import com.pacific.secrethitler.test.TestData;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test class that has main method that simulates the Runner.
 */
public class MainTest {

    private static final Logger logger = LoggerFactory.getLogger(MainTest
            .class.getSimpleName());

    public static void main(String[] args) {
        String numberOfPlayers = getNumOfPlayers(args);

        final TestData testData = TestData.newTestData(Integer.parseInt
                (numberOfPlayers), new CollectionsShuffler());
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

    private static String getNumOfPlayers(String[] args) {
        final Options options = new Options();

        final Option numOfPlayers = new Option("n", "numOfPlayers", true,
                "Number of players");
        numOfPlayers.setRequired(true);
        options.addOption(numOfPlayers);

        final CommandLineParser parser = new GnuParser();
        final HelpFormatter formatter = new HelpFormatter();
        final CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            logger.error("Got exception in parsing command line arguments", e);
            formatter.printHelp("SecretHitlerLib", options);
            System.exit(1);
            return "";
        }

        return cmd.getOptionValue("numOfPlayers");
    }
}
