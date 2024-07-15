package com.openclassrooms.cardgame.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.openclassrooms.cardgame.controller.GameController;

/*
 * creation of multiple views as per composite pattern
 * when this is called, all the views will be iterated and its display will be update
 */
public class GameViewables implements GameViewable {
    Vector<GameViewable> views;

    public GameViewables() {
        views = new Vector<GameViewable>();
    }

    public void addViewable(GameViewable view){
        views.add(view);
    }

    @Override
    public void setController(GameController controller){
        for (GameViewable view : views){
            view.setController(controller);
        }
    }

    @Override
    public void promptForPlayerName(){
        for (GameViewable view : views){
            view.promptForPlayerName();
        }
    }

    @Override 
    public void promptForFlip(){
        for (GameViewable view : views){
            view.promptForFlip();
        }
    }

    @Override
    public void promptForNewGame(){
        for (GameViewable view : views){
            view.promptForNewGame();
        }
    }

    public void showFaceDownCardForPlayer(int playerIndex, String name){
        for (GameViewable view : views){
            view.showFaceDownCardForPlayer(playerIndex, name);
        }
    }

    public void showWinner(String name){
        for (GameViewable view : views){
            view.showWinner(name);
        }
    }

    public void showPlayerName(int size, String playerName){
        for (GameViewable view : views){
            view.showPlayerName(size, playerName);
        }
    }

    public void showCardForPlayer(int playerIndex, String name, String rank, String suit){
        for (GameViewable view : views){
            view.showCardForPlayer(playerIndex, name, rank, suit);
        }
    }
}
