package com.openclassrooms.cardgame.model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/*
 * a deck class with a constructor and deck methods
 */
public class Deck {
    ArrayList<PlayingCard> cards;

    /*
     * creates a deck by initializing an array and iterating through all the 
     */
    public Deck(){
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

    public void shuffle(){
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++){
            Collections.swap(cards, i, random.nextInt(cards.size()));
        }
    }

    public PlayingCard removeTopCard(){
        return cards.remove(0);
    }

    public void returnCardToDeck(PlayingCard card){
        cards.add(card);
    }
}
