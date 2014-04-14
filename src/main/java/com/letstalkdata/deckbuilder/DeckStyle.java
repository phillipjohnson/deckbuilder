package com.letstalkdata.deckbuilder;

/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public enum DeckStyle {

    /**
     * The standard 52 card deck consisting of four suits
     * (Clubs, Spades, Diamonds, Hearts) each of which have
     * 13 cards ranked two through 10, Jack, Queen, King, and Ace.
     */
    STANDARD_52,

    /**
     * The same as STANDARD_52 except with an added Joker.
     */
    STANDARD_52_PLUS_JOKER,

    /**
     * The same as STANDARD_52 exception with two added Jokers.
     */
    STANDARD_52_PLUS_TWO_JOKERS,

    /**
     * Indicates the Deck will be populated by the user with a custom Collection of Cards.
     */
    CUSTOM,

}
