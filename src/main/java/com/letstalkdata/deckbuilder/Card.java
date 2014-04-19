package com.letstalkdata.deckbuilder;

/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class Card {

    private final CardRank rank;
    private final CardSuit suit;

    public Card(CardRank rank, CardSuit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Card(CardRank.Standard rank,CardSuit.Standard suit){
        this.rank = new CardRank(rank);
        this.suit = new CardSuit(suit);
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardColor getColor(){
        return suit.getColor();
    }

    /**
     * Compares the specified Card's rank to this Card's rank.
     *
     * @param c the specified Card
     * @return {@code true} if the ranks are equal
     */
    public boolean equalsRankOf(Card c){
        return rank.equals(c.getRank());
    }

    /**
     * Compares the specified Card's suit to the Card's suit.
     *
     * @param c the specified Card
     * @return {@code true} if the suits are equal
     */
    public boolean equalsSuitOf(Card c){
        return suit.equals(c.getSuit());
    }

    @Override
    public String toString(){
        return "Rank: [" + rank + "] Suit: [" + suit + "]";
    }

    /**
     * Compares the specified object with this Card for equality.
     *
     * Returns {@code true} if and only if the specified object is a Card
     * and its rank and suit are equal to this Card's rank and suit.
     *
     * @param o the specified object to compare to this Card
     * @return  {@code true} if the specified object equals this Card
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != null ? !rank.equals(card.rank) : card.rank != null) return false;
        if (suit != null ? !suit.equals(card.suit) : card.suit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rank != null ? rank.hashCode() : 0;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }
}
