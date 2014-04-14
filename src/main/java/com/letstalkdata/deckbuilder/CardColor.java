package com.letstalkdata.deckbuilder;

/**
 * A Color that can be assigned to a suit.
 *
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class CardColor {

    public enum Standard{
        RED("Red"),
        BLACK("Black"),
        NONE("None");

        private final String name;

        private Standard(String name){
            this.name = name;
        }

        private String getName(){
            return name;
        }
    }

    private String name;

    public CardColor(Standard color){
        this.name = color.getName();
    }

    /**
     * Compares the specified object with this CardColor for equality.
     *
     * Returns {@code true} if and only if the object is a CardColor and its
     * name matches the name of this CardColor.
     * @param o the object to be compared for equality with this CardColor
     * @return  {@code true} if the specified object is equal to this CardColor
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardColor cardColor = (CardColor) o;

        if (name != null ? !name.equals(cardColor.name) : cardColor.name != null) return false;

        return true;
    }

    /**
     * Returns the hashcode value for this CardColor.
     *
     * @return the hashcode value for this CardColor.
     */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
