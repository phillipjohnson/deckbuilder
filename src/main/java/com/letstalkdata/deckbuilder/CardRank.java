package com.letstalkdata.deckbuilder;

/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class CardRank implements Comparable {

    public enum Standard{

        ACE_LOW("Ace",1),
        ACE_HIGH("Ace",14),
        TWO("Two",2),
        THREE("Three",3),
        FOUR("Four",4),
        FIVE("Five",5),
        SIX("Six",6),
        SEVEN("Seven",7),
        EIGHT("Eight",8),
        NINE("Nine",9),
        TEN("Ten",10),
        JACK("Jack",11),
        QUEEN("Queen",12),
        KING("King",13),
        JOKER_ACE_LOW("Joker",14),
        JOKER_ACE_HIGH("Joker",15);

        private String name;
        private int value;

        private Standard(String name, int value){
            this.name = name;
            this.value = value;
        }

        private String getName() {
            return name;
        }

        private int getValue() {
            return value;
        }
    }

    private final String name;
    private final int value;

    /**
     * Creates a standard CardRank
     * @param rank the rank to create
     */
    public CardRank(Standard rank){
        this.name = rank.getName();
        this.value = rank.getValue();
    }

    /**
     * Creates a custom CardRank with a given name and value.
     * @param name  the name of the rank
     * @param value the value of the rank
     */
    public CardRank(String name, int value) {
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    /**
     * Compares this CardRank with the specified object for order.
     *
     * Returns the difference of the this CardRank's value and the
     * specified CardRank's value. This implies that two CardRanks
     * with the same value are equally ranked.
     *
     * @param o the specified object to check for comparability
     * @return  a negative integer, zero, or a positive integer as this
     * object is less than, equal to, or greater than the specified object.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        return this.value - ((CardRank) o).value;
    }

    @Override
    public String toString(){
        return name + "(" + value + ")";
    }

    /**
     * Compares the specified object with this CardRank for equality.
     *
     * Returns {@code true} if and only if the object is a CardRank and
     * its name and value are equal to this CardRank's name and value.
     *
     * @param o the specified object to check for equality
     * @return  {@code true} if the specified object is equal to this CardRank.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardRank cardRank = (CardRank) o;

        if (value != cardRank.value) return false;
        if (name != null ? !name.equals(cardRank.name) : cardRank.name != null) return false;

        return true;
    }

    /**
     * Returns the hashcode of this CardRank.
     *
     * @return  the hashcode of this CardRank.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }


}
