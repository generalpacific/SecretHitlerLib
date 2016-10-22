package com.pacific.secrethitler.game.test;

import com.pacific.secrethitler.game.shuffle.DumbShuffler;
import com.pacific.secrethitler.player.Player;
import com.pacific.secrethitler.test.TestData;
import com.pacific.secrethitler.types.Policy;
import com.pacific.secrethitler.types.Role;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class TestDataTest {

    private final int numOfPlayers;
    private final int numOfExpectedLiberals;

    public TestDataTest(int numOfPlayers, int numOfLiberals) {
        this.numOfPlayers = numOfPlayers;
        this.numOfExpectedLiberals = numOfLiberals;
    }

    @Parameterized.Parameters(name = "{index}: testData({0}, {1})")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{{5, 3}, {6, 4}, {7, 4}, {8, 5},
                {9, 5}, {10, 6}});
    }

    @Test
    public void testInitialPolicies() {
        final TestData testData = TestData.newTestData(numOfPlayers, new
                DumbShuffler());
        final List<Policy> initialPolicies = testData.getInitialPolicies();
        assertThat("Size of initial policies doesn't match", initialPolicies
                .size(), is(17));
    }

    @Test
    public void testInitialPlayers() {
        final TestData testData = TestData.newTestData(numOfPlayers, new
                DumbShuffler());
        final List<Player> initialPlayers = testData.getInitialPlayers();

        final int actualNumOfLiberals = initialPlayers.stream().filter(p -> p
                .getRole().equals(Role.LIBERAL)).collect(Collectors.toList())
                .size();
        final int actualNumOfFascists = initialPlayers.stream().filter(p -> p
                .getRole().equals(Role.FASCIST)).collect(Collectors.toList())
                .size();
        final int actualNumOfHitler = initialPlayers.stream().filter(p -> p
                .getRole().equals(Role.HITLER)).collect(Collectors.toList())
                .size();

        assertThat("Number of liberals doesnt match", actualNumOfLiberals, is
                (numOfExpectedLiberals));
        assertThat("Number of fascists doesnt match", actualNumOfFascists, is
                (numOfPlayers - numOfExpectedLiberals - 1));
        assertThat("Number of hitler doesnt match", actualNumOfHitler, is(1));
    }

}
