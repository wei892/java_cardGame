package com.openclassrooms.cardgame.model;

/*
 * create a playing card class 
 * has a playing card constructor and some functions that reutrn the playing card info
 */
public class PlayingCard {
    Rank rank;
    Suit suit;
    boolean faceUp;

    public PlayingCard(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        this.faceUp = false;
    }

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public boolean isFaceUp(){
        return faceUp;
    }

    public boolean flip(){
        faceUp = !faceUp;
        return faceUp;
    }
}
