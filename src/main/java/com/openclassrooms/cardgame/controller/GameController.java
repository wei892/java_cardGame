package com.openclassrooms.cardgame.controller;

import java.util.ArrayList;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.view.GameViewable;

/*
 * our game controller is the closed class
 * it always walks through the sequence of events that does not change
 * the open part is the game evaluator interface which will allow for flexibility of implementation so we can easily change the rules of the game
 */
public class GameController {
    enum GameState{
        AddingPlayers,
        CardsDealt,
        WinnersRevealed;
    }

    Deck deck;
    ArrayList<Player> players;
    Player winner;
    GameViewable view;
    GameState gameState;
    GameEvaluator evaluator;

    /*adding a controller class will allow us to implement the type of game rules we need: (highest card vs lowest card)
    this will allow us to pass in the correct specific implementation*/
    public GameController(GameViewable view, Deck deck, GameEvaluator evaluator){
        this.view = view;
        this.deck = deck;
        players = new ArrayList<Player>();
        gameState = GameState.AddingPlayers;
        this.evaluator = evaluator;
        view.setController(this);
    }

    public void run(){
        while(true){
            switch (gameState) {
                case AddingPlayers:
                    view.promptForPlayerName();
                    break;
                case CardsDealt:
                    view.promptForFlip();
                    break;
                case WinnersRevealed:
                    view.promptForNewGame();
                    break;
            }
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers){
            players.add(new Player(playerName));
            view.showPlayerName(players.size(), playerName);
        }
    }

    public void startGame(){
        if (gameState != GameState.CardsDealt){
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players){
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }

    public void FlipCards(){
        int playerIndex = 1;
        for (Player player : players) {
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
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
        winner = evaluator.evaluateWinner(players);
    }

    void displayerWinner(){
        view.showWWinner(winner.getName());
    }

    void rebuildDeck(){
        for (Player player : players){
            deck.returnCardToDeck(player.removeCard());
        }
    }

}
