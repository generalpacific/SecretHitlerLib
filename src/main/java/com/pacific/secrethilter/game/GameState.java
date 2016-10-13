package com.pacific.secrethilter.game;

import com.google.common.collect.ImmutableMap;

import com.pacific.secrethilter.player.Player;
import com.pacific.secrethilter.types.Policy;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Game State object used during the game. The class contains the whole context of the game.
 * <p>
 * Following information is maintained by {@link GameState}:
 * <ul>
 * <li>The deck of policies.</li>
 * <li>The liberal and the fascist track.</li>
 * <li>The number of players.</li>
 * </ul>
 *
 * @author prashantchaudhary
 */
public class GameState {

    private final DrawPolicyDeck drawPolicyDeck;
    private final PolicyTrack liberalPolicyTrack;
    private final PolicyTrack fascistPolicyTrack;
    private final Map<String, Player> players;

    private String currentPresident;
    private String currentChancellor;


    private GameState(final List<Policy> initialShuffledPolicies, final Set<Player> initialPlayers) {
        drawPolicyDeck =
                QueueDrawPolicyDeck.newDrawPolicyDeck(initialShuffledPolicies);
        liberalPolicyTrack = PolicyTrack.newPolicyTrack();
        fascistPolicyTrack = PolicyTrack.newPolicyTrack();
        players = initialPlayers.stream().collect(Collectors.toMap(Player::getPlayerId, Function.identity()));
    }

    public static GameState newGameState(
            final List<Policy> initialShuffledPolicies, final Set<Player> initialPlayers) {
        return new GameState(initialShuffledPolicies, initialPlayers);
    }

    public Policy drawPolicy() {
        return drawPolicyDeck.drawPolicy();
    }

    public void enactPolicy(final Policy policy) {
        if (Policy.LIBERAL.equals(policy)) {
            liberalPolicyTrack.enactPolicy();
        } else {
            fascistPolicyTrack.enactPolicy();
        }
    }

    public void setCurrentPresident(String playerId) {
        currentPresident = playerId;
    }

    public void setCurrentChancellor(String playerId) {
        currentChancellor = playerId;
    }
}
