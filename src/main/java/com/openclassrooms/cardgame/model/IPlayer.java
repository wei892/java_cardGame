package com.openclassrooms.cardgame.model;

/*
 * Player class contains a name and a hand
 * other than name, player's actions extend from hand class
 */
public interface IPlayer {
    public String getName();
    public void addCardToHand(PlayingCard card);
    public PlayingCard getCard(int index);
    public PlayingCard removeCard();
}
