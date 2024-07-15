package com.openclassrooms.cardgame.controller;

import java.util.ArrayList;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.model.WinningPlayer;
import com.openclassrooms.cardgame.view.GameViewable;
import com.openclassrooms.cardgame.view.GameViewables;

/*
 * our game controller is the closed class
 * it always walks through the sequence of events that does not change
 * the open part is the game evaluator interface which will allow for flexibility of implementation so we can easily change the rules of the game
 */
public class GameController {
    enum GameState{
        AddingPlayers,
        CardsDealt,
        WinnersRevealed, 
        AddingView;
    }

    Deck deck;
    ArrayList<IPlayer> players;
    IPlayer winner;
    GameViewables views;
    GameState gameState;
    GameEvaluator evaluator;

    /*adding a controller class will allow us to implement the type of game rules we need: (highest card vs lowest card)
    this will allow us to pass in the correct specific implementation*/
    public GameController(GameViewable view, Deck deck, GameEvaluator evaluator){
        views = new GameViewables();
        this.deck = deck;
        this.evaluator = evaluator;
        players = new ArrayList<IPlayer>();
        gameState = GameState.AddingPlayers;
        addViewable(view);
    }

    public void addViewable(GameViewable newView){
        GameState currentState = gameState;
        gameState = GameState.AddingView;
        newView.setController(this);
        views.addViewable(newView);
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        gameState = currentState;
    }

    public void run(){
        while(true){
            switch (gameState) {
                case AddingPlayers:
                    views.promptForPlayerName();
                    break;
                case CardsDealt:
                    views.promptForFlip();
                    break;
                case WinnersRevealed:
                    views.promptForNewGame();
                    break;
                case AddingView:
                    break;
            }
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers){
            players.add(new Player(playerName));
            views.showPlayerName(players.size(), playerName);
        }
    }

    public void startGame(){
        if (gameState != GameState.CardsDealt){
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer player : players){
                player.addCardToHand(deck.removeTopCard());
                views.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }

    public void FlipCards(){
        int playerIndex = 1;
        for (IPlayer player : players) {
            PlayingCard pc = player.getCard(0);
            pc.flip();
            views.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
        }

        evaluateWinner();
        displayerWinner();
        rebuildDeck();
        gameState = GameState.WinnersRevealed;
    }

    public void restartGame(){
        rebuildDeck();
        gameState = GameState.AddingPlayers;
    }

    void evaluateWinner(){
        winner = new WinningPlayer(evaluator.evaluateWinner(players));
    }

    void displayerWinner(){
        views.showWinner(winner.getName());
    }

    void rebuildDeck(){
        for (IPlayer player : players){
            deck.returnCardToDeck(player.removeCard());
        }
    }

}
