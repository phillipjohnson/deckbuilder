package com.letstalkdata.deckbuilder;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class DeckTest {

    @Test
    public void standardDeckMeetsRequirements(){
        Deck d = new Deck(DeckStyle.STANDARD_52,AceBehavior.ACES_LOW);
        assertTrue(d.size()==52);
        assertFalse(d.contains(new Card(
                new CardRank(CardRank.Standard.JOKER_ACE_LOW),
                new CardSuit(CardSuit.Standard.NONE))));
    }

    @Test
    public void jokerDeckHasJoker(){
        Deck d = new Deck(DeckStyle.STANDARD_52_PLUS_JOKER,AceBehavior.ACES_LOW);
        assertTrue(d.size()==53);
        assertTrue(d.contains(new Card(
                new CardRank(CardRank.Standard.JOKER_ACE_LOW),
                new CardSuit(CardSuit.Standard.NONE))));
    }

    @Test
    public void copyDeck(){
        Deck d = new Deck(DeckStyle.STANDARD_52_PLUS_JOKER,AceBehavior.ACES_LOW);
        Deck d2 = new Deck(d);
        d.clear();

        assertFalse(d2.isEmpty()); //Making a copy should not retain references
    }

    @Test
    public void testAceBehavior(){
        Deck d = new Deck(DeckStyle.STANDARD_52,AceBehavior.ACES_LOW);
        assertTrue(d.contains(new Card(
                new CardRank(CardRank.Standard.ACE_LOW),
                new CardSuit(CardSuit.Standard.HEART))));

        d = new Deck(DeckStyle.STANDARD_52,AceBehavior.ACES_HIGH);
        assertTrue(d.contains(new Card(
                new CardRank(CardRank.Standard.ACE_HIGH),
                new CardSuit(CardSuit.Standard.HEART))));
    }

}
