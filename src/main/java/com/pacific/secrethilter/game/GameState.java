package com.pacific.secrethilter.game;

import java.util.List;

import com.pacific.secrethilter.types.Policy;


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

  private GameState(final List<Policy> initialShuffledPolicies) {
    drawPolicyDeck =
        QueueDrawPolicyDeck.newDrawPolicyDeck(initialShuffledPolicies);
    liberalPolicyTrack = PolicyTrack.newPolicyTrack();
    fascistPolicyTrack = PolicyTrack.newPolicyTrack();
  }

  public static GameState newGameState(
      final List<Policy> initialShuffledPolicies) {
    return new GameState(initialShuffledPolicies);
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
}
