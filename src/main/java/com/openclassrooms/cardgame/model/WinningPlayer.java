package com.openclassrooms.cardgame.model;

public class WinningPlayer implements IPlayer{
    IPlayer winner;
    public WinningPlayer(IPlayer player){
        winner = player;
    }

    @Override
    public String getName(){
        return "***** " + winner.getName() + " *****";
    }

    @Override
    public void addCardToHand(PlayingCard card){
        
    }

    @Override
    public PlayingCard getCard(int index){

    }

    @Override
    public PlayingCard removeCard(){

    }
}
