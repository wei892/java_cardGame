package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

/*
 * Hand class where each hand represents the cards that a player has
 * has respective actions that allows them to add card,, get a card at index, and remove the top card
 */
public class Hand {
    ArrayList<PlayingCard> cards;

    public Hand(){
        cards = new ArrayList<PlayingCard> ();
    }

    public void addCard(PlayingCard card){
        cards.add(card);
    }

    public PlayingCard getCard(int index){
        return cards.get(index);
    }

    public PlayingCard removeCard() {
        return cards.remove(0);
    }
}
