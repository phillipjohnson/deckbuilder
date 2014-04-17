package com.letstalkdata.deckbuilder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class Hand extends ForwardingLinkedList<Card>{

    public Hand(Collection<? extends Card> cards){
        super(new LinkedList<>(cards));
    }

    /**
     * Returns a view of the current hand that matches a given suit.
     *
     * @param suit the suit to match
     * @return a view of the current hand that matches the given suit.
     */
    public List<Card> forSuit(CardSuit suit){
        List<Card> newHand = this.stream()
                .filter((c) -> c.getSuit().equals(suit))
                .collect(Collectors.toList());
        return new Hand(newHand);
    }

    /**
     * Returns a view of the current hand that matches a given rank.
     *
     * @param rank the rank to match
     * @return a view of the current hand that matches the given rank.
     */
    public List<Card> forRank(CardRank rank){
        List<Card> newHand = this.stream()
                .filter((c) -> c.getRank().equals(rank))
                .collect(Collectors.toList());
        return new Hand(newHand);
    }

    /**
     * Returns a view of the current hand that matches a given color.
     *
     * @param color the color to match
     * @return a view of the current hand that matches the given color.
     */
    public List<Card> forColor(CardColor color){
        List<Card> newHand = this.stream()
                .filter((c) -> c.getColor().equals(color))
                .collect(Collectors.toList());
        return new Hand(newHand);
    }
}
