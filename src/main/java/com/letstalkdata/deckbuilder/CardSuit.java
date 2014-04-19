package com.letstalkdata.deckbuilder;

/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class CardSuit {

    public enum Standard{
        CLUB("Club",new CardColor(CardColor.Standard.BLACK)),
        DIAMOND("Diamond",new CardColor(CardColor.Standard.RED)),
        HEART("Heart",new CardColor(CardColor.Standard.RED)),
        SPADE("Spade",new CardColor(CardColor.Standard.BLACK)),
        NONE("None",new CardColor(CardColor.Standard.NONE));

        private final String name;
        private final CardColor color;

        private Standard(String name, CardColor color){
            this.name = name;
            this.color = color;
        }

        private CardColor getColor(){
            return color;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    private final String name;
    private final CardColor color;

    /**
     * Creates one of the standard card suits.
     * @param suit the standard suit to create
     */
    public CardSuit(CardSuit.Standard suit){
        this.name = suit.toString();
        this.color = suit.getColor();
    }

    /**
     * Creates a custom CardSuit with the given name and CardColor.
     *
     * @param name  the name of this Suit
     * @param color the CardColor of this suit
     */
    public CardSuit(String name, CardColor color) {
        this.name = name;
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

    private boolean isStandardSuit(){
        for(CardSuit.Standard standard: CardSuit.Standard.values()){
            if(this.equals(new CardSuit(standard))){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string with the name and color (if present) of the CardSuit.
     *
     * Standard suits will be abbreviated.
     *
     * @return the string value of the CardSuit
     */
    @Override
    public String toString(){
        String val = "";
        if(isStandardSuit()){
            if(this.equals(new CardSuit(Standard.CLUB))){
                val = "C";
            } else if(this.equals(new CardSuit(Standard.DIAMOND))){
                val = "D";
            } else if(this.equals(new CardSuit(Standard.SPADE))){
                val = "S";
            } else if(this.equals(new CardSuit(Standard.HEART))){
                val = "H";
            }
        } else {
            val = name;
            if (!color.equals(new CardColor(CardColor.Standard.NONE))) {
                val += " (" + color + ")";
            }
        }

        return val;
    }

    /**
     * Compares this CardSuit with the specified object for equality.
     *
     * Returns true if and only if the specified object is a CardSuit and
     * this CardSuit's name and color are equal to the object's.
     *
     * @param o the object to check for equality
     * @return  {@code true} if this CardSuit is equal to the specified object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardSuit cardSuit = (CardSuit) o;

        if (color != null ? !color.equals(cardSuit.color) : cardSuit.color != null) return false;
        if (name != null ? !name.equals(cardSuit.name) : cardSuit.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}