package com.letstalkdata.deckbuilder;

import java.util.*;

/**
 * A Deck is a group of cards from which Cards can be retrieved.
 *
 * The Deck object is backed by a LinkedList ensuring a fixed order of cards.
 * It is suggested that you call {@link #shuffle()} after creating a new deck.
 *
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public final class Deck extends ForwardingLinkedList<Card> {

    private final DeckStyle style;
    private final AceBehavior aceBehavior;

    /**
     * Creates a deck according to the specified style.
     * @param style the style of deck to create
     */
    public Deck(DeckStyle style, AceBehavior aceBehavior){
        super(buildDeck(style,aceBehavior));
        this.style = style;
        this.aceBehavior = aceBehavior;

    }

    /**
     * Creates a custom deck with the given cards.
     * @param cards the Cards with which to create this deck
     */
    public Deck(Collection<? extends Card> cards){
        super(new LinkedList<>(cards));
        this.style = DeckStyle.CUSTOM;
        this.aceBehavior = AceBehavior.NONE;
    }

    /**
     * Creates a copy of another Deck.
     *
     * @param toCopy the Deck to copy
     */
    public Deck(Deck toCopy){
        super(new LinkedList<>(toCopy));
        this.style = toCopy.style;
        this.aceBehavior = toCopy.aceBehavior;
    }

    /**
     * Returns a set of the unique suits in this deck.
     *
     * @return the set of unique suits in this deck.
     */
    public Set<CardSuit> getUniqueSuits(){
        Set<CardSuit> suits = new HashSet<>();
        for(Card c : this){
            suits.add(c.getSuit());
        }

        return suits;
    }

    /**
     * Forward of {@link java.util.Collections#shuffle(java.util.List)}
     */
    public void shuffle(){
        Collections.shuffle(this);
    }

    private static LinkedList<Card> buildDeck(DeckStyle style, AceBehavior aceBehavior){
        LinkedList<Card> deck = new LinkedList<>();
        switch(style) {
            case STANDARD_52:
                deck.addAll(buildStandardDeck(aceBehavior));
                break;
            case STANDARD_52_PLUS_JOKER:
                deck.addAll(buildStandardDeck(aceBehavior));
                if (aceBehavior == AceBehavior.ACES_LOW) {
                    deck.add(new Card(
                            new CardRank(CardRank.Standard.JOKER_ACE_LOW),
                            new CardSuit(CardSuit.Standard.NONE)));
                } else {
                    deck.add(new Card(
                            new CardRank(CardRank.Standard.JOKER_ACE_HIGH),
                            new CardSuit(CardSuit.Standard.NONE)));
                }
                break;
            case STANDARD_52_PLUS_TWO_JOKERS:
                deck.addAll(buildStandardDeck(aceBehavior));
                if (aceBehavior == AceBehavior.ACES_LOW) {
                    deck.add(new Card(
                            new CardRank(CardRank.Standard.JOKER_ACE_LOW),
                            new CardSuit(CardSuit.Standard.NONE)));
                    deck.add(new Card(
                            new CardRank(CardRank.Standard.JOKER_ACE_LOW),
                            new CardSuit(CardSuit.Standard.NONE)));
                } else {
                    deck.add(new Card(
                            new CardRank(CardRank.Standard.JOKER_ACE_HIGH),
                            new CardSuit(CardSuit.Standard.NONE)));
                    deck.add(new Card(
                            new CardRank(CardRank.Standard.JOKER_ACE_HIGH),
                            new CardSuit(CardSuit.Standard.NONE)));
                }
                break;
            case CUSTOM:
                break;
        }

        return deck;
    }

    private static LinkedList<Card> buildStandardDeck(AceBehavior aceBehavior){
        LinkedList<Card> deck = new LinkedList<>();
        for(CardSuit.Standard s : CardSuit.Standard.values()){
            if(s!=CardSuit.Standard.NONE){
                if(aceBehavior==AceBehavior.ACES_LOW){
                    deck.add(new Card(new CardRank(CardRank.Standard.ACE_LOW),new CardSuit(s)));
                } else {
                    deck.add(new Card(new CardRank(CardRank.Standard.ACE_HIGH),new CardSuit(s)));
                }
                deck.add(new Card(new CardRank(CardRank.Standard.TWO),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.THREE),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.FOUR),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.FIVE),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.SIX),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.SEVEN),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.EIGHT),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.NINE),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.TEN),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.JACK),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.QUEEN),new CardSuit(s)));
                deck.add(new Card(new CardRank(CardRank.Standard.KING),new CardSuit(s)));
            }
        }

        return deck;
    }
}
