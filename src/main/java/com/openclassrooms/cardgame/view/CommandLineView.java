package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;
import java.util.Scanner;

public class CommandLineView implements GameViewable{
    GameController controller;
    Scanner keyboard = new Scanner(System.in);

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void promptForPlayerName() {
        System.out.print("Enter player name: ");
        String name = keyboard.nextLine();

        if (name.isEmpty()){
            controller.startGame();
        }
        else{
            controller.addPlayer(name);
        }
    }
    public void promptForFlip() {
        System.out.println("Press enter to reveal cards");
        keyboard.nextLine();
        controller.FlipCards();
    }

    public void promptForNewGame() {
        System.out.println("Press enter to deal again");
        keyboard.nextLine();
        controller.startGame();
    }

    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        System.out.println("[" + name + "][][]");
    }

    public void showWinner(String name) {
        System.out.println("Winner: " + name +"!");
    }

    public void showPlayerName(int size, String playerName) {
        System.out.println("[" + size + "][" + playerName + "]");
    }

    public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
        System.out.println("[" + name + "][" + rank + "][" + suit + "]");
    }
}
