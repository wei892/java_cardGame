package com.openclassrooms.cardgame.model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/*
 * a deck class with a constructor and deck methods
 */
public abstract class Deck {
    ArrayList<PlayingCard> cards;
    
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
