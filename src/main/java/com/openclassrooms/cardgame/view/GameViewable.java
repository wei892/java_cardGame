package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;


//
public interface GameViewable {
    public void setController(GameController controller);
    public void promptForPlayerName();

     void promptForFlip();

    void promptForNewGame();

    void showFaceDownCardForPlayer(int playerIndex, String name);

    void showWWinner(String name);

    void showPlayerName(int size, String playerName);

    void showCardForPlayer(int playerIndex, String name, String rank, String suit);
}
