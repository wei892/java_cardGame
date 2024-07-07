package com.openclassrooms.cardgame.model;

/*
 * Player class contains a name and a hand
 * other than name, player's actions extend from hand class
 */
public class Player {
    String name;
    Hand hand;

    public Player(String name){
        this.name = name;
        hand = new Hand();
    }

    public String getName(){
        return name;
    }

    public void addCardToHand(PlayingCard card){
        hand.addCard(card);
    }

    public PlayingCard getCard(int index){
        return hand.getCard(index);
    }

    public PlayingCard removeCard(){
        return hand.removeCard();
    }
}
