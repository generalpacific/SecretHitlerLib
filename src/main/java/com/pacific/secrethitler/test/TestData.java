package com.pacific.secrethitler.test;

import com.google.common.collect.ImmutableList;

import com.pacific.secrethitler.game.shuffle.CollectionsShuffler;
import com.pacific.secrethitler.game.shuffle.Shuffler;
import com.pacific.secrethitler.player.DumbPolicyDecider;
import com.pacific.secrethitler.player.DumbVoteCaster;
import com.pacific.secrethitler.player.Player;
import com.pacific.secrethitler.types.Policy;
import com.pacific.secrethitler.types.Role;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class has methods for generating test data.
 */
public class TestData {

    private final int numOfPlayers;
    private final Shuffler shuffler;

    private TestData(final int numOfPlayers, final Shuffler shuffler) {
        this.numOfPlayers = numOfPlayers;
        this.shuffler = shuffler;
    }

    public static TestData newTestData(final int numOfPlayers, final Shuffler
            shuffler) {
        return new TestData(numOfPlayers, shuffler);
    }

    public List<Policy> getInitialPolicies() {
        final ImmutableList.Builder<Policy> policies = ImmutableList.builder();
        policies.addAll(IntStream.range(0, 11).mapToObj(i -> Policy.FASCIST)
                .collect(Collectors.toList()));
        policies.addAll(IntStream.range(0, 6).mapToObj(i -> Policy.LIBERAL)
                .collect(Collectors.toList()));
        return shuffler.shuffle(policies.build());
    }

    public List<Player> getInitialPlayers() {
        final ImmutableList.Builder<Player> players = ImmutableList.builder();
        players.add(Player.builder().setPlayerId("player0").setRole(Role
                .LIBERAL).setPolicyDecider(new DumbPolicyDecider())
                .setVoteCaster(new DumbVoteCaster()).build());
        players.add(Player.builder().setPlayerId("player1").setRole(Role
                .LIBERAL).setPolicyDecider(new DumbPolicyDecider())
                .setVoteCaster(new DumbVoteCaster()).build());
        players.add(Player.builder().setPlayerId("player2").setRole(Role
                .LIBERAL).setPolicyDecider(new DumbPolicyDecider())
                .setVoteCaster(new DumbVoteCaster()).build());
        players.add(Player.builder().setPlayerId("player3").setRole(Role
                .FASCIST).setPolicyDecider(new DumbPolicyDecider())
                .setVoteCaster(new DumbVoteCaster()).build());
        players.add(Player.builder().setPlayerId("player4").setRole(Role
                .HITLER).setPolicyDecider(new DumbPolicyDecider())
                .setVoteCaster(new DumbVoteCaster()).build());
        return shuffler.shuffle(players.build());
    }

    public String getFirstPresident() {
        final Random rand = new Random(System.currentTimeMillis());
        return "player" + rand.nextInt(6);
    }
}
