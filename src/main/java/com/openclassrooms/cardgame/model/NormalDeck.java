package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

public class NormalDeck extends Deck{
    /*
     * creates a deck by initializing an array and iterating through all the 
     */
    public NormalDeck(){
        // <> is used to allow the compiler to infer the type arguments based on the variable's declared deck
        cards = new ArrayList<>();
        for (Rank rank : Rank.values()){
            for (Suit suit : Suit.values()){
                System.out.println("creating card: [" + rank + " OF " + suit + "]");
                cards.add(new PlayingCard(rank, suit));
            }
        }
        shuffle(); //we need to implement shuffle to ensure that the deck is always randomized
    }
    
}
