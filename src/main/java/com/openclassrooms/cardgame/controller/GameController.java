package com.openclassrooms.cardgame.controller;

import java.util.ArrayList;

import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.view.View;

public class GameController {
    enum GameState{
        AddingPlayers,
        CardsDealt,
        WinnersRevealed;
    }

    Deck deck;
    ArrayList<Player> players;
    Player winner;
    View view;
    GameState gameState;

    public GameController(View view, Deck deck){
        this.view = view;
        this.deck = deck;
        players = new ArrayList<Player>();
        gameState = GameState.AddingPlayers;
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

    void evaluateWinner(){
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players){
            boolean newBestPlayer = false;

            if (bestPlayer == null){
                newBestPlayer = true;
            }
            else{
                PlayingCard card = player.getCard(0);
                int thisRank = card.getRank().value();
                if (thisRank >= bestRank){
                    if (thisRank > bestRank){
                        newBestPlayer = true;
                    }
                    else {
                        if (card.getSuit().value() > bestSuit){
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer){
                bestPlayer = player;
                PlayingCard card = player.getCard(0);
                bestRank = card.getRank().value();
                bestSuit = card.getSuit().value();
            }
        }

        winner = bestPlayer;
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
