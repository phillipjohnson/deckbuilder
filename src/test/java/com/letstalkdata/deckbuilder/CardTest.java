package com.letstalkdata.deckbuilder;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class CardTest {
    @Test
    public void testEqualsRankOf() throws Exception {
        Card c1 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.CLUB));
        Card c2 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.HEART));
        Card c3 = new Card(new CardRank(CardRank.Standard.TEN),new CardSuit(CardSuit.Standard.HEART));

        assertTrue(c1.equalsRankOf(c2));
        assertFalse(c1.equalsRankOf(c3));
        assertFalse(c2.equalsRankOf(c3));

    }

    @Test
    public void testEqualsSuitOf() throws Exception {
        Card c1 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.CLUB));
        Card c2 = new Card(new CardRank(CardRank.Standard.TEN),new CardSuit(CardSuit.Standard.CLUB));
        Card c3 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.HEART));

        assertTrue(c1.equalsSuitOf(c2));
        assertFalse(c1.equalsSuitOf(c3));
        assertFalse(c2.equalsSuitOf(c3));
    }

    @Test
    public void testEquals() throws Exception {
        Card c1 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.CLUB));
        Card c2 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.CLUB));

        assertTrue(c1.equals(c2));

        c1 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.CLUB));
        c2 = new Card(new CardRank(CardRank.Standard.TEN),new CardSuit(CardSuit.Standard.CLUB));

        assertFalse(c1.equals(c2));

        c1 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.CLUB));
        c2 = new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(CardSuit.Standard.HEART));

        assertFalse(c1.equals(c2));

    }
}
