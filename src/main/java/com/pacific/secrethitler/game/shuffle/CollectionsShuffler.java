package com.pacific.secrethitler.game.shuffle;

import com.pacific.secrethitler.player.Player;
import com.pacific.secrethitler.types.Policy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Basic shuffler based on java's Collections.
 */
public class CollectionsShuffler implements Shuffler<Object> {

    @Override
    public List<Object> shuffle(List<Object> policies) {
        final List<Object> tempList = new ArrayList<>(policies);
        Collections.shuffle(tempList, new Random(System.currentTimeMillis()));
        return tempList;
    }
}
