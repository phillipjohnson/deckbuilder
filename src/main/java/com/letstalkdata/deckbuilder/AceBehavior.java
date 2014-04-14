package com.letstalkdata.deckbuilder;

/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public enum AceBehavior {

    /**
     * Creates Aces with a rank higher than King and lower than Joker.
     */
    ACES_HIGH,

    /**
     * Creates Aces with a rank lower than Two.
     */
    ACES_LOW,

    /**
     * Used when Ace rank is not applicable.
     */
    NONE,

}
