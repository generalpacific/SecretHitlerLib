package com.pacific.secrethitler.game.shuffle;

import com.pacific.secrethitler.types.Policy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Basic shuffler based on java's Collections.
 */
public class CollectionsShuffler implements Shuffler {

    @Override
    public List<Policy> shuffle(List<Policy> policies) {
        final List<Policy> tempList = new ArrayList<>(policies);
        Collections.shuffle(tempList, new Random(System.currentTimeMillis()));
        return tempList;
    }
}
