package com.letstalkdata.deckbuilder;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Author: Phillip Johnson
 * Date: 4/13/14
 */
public class Hand extends ForwardingLinkedList<Card>{

    public Hand(Collection<? extends Card> cards){
        super(new LinkedList<>(cards));
    }
}
