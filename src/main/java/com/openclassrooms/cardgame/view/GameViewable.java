package com.openclassrooms.cardgame.view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.openclassrooms.cardgame.controller.GameController;


//
public interface GameViewable {
    public void setController(GameController controller);

    public void promptForPlayerName();

     void promptForFlip();

    void promptForNewGame();

    void showFaceDownCardForPlayer(int playerIndex, String name);

    void showWinner(String name);

    void showPlayerName(int size, String playerName);

    void showCardForPlayer(int playerIndex, String name, String rank, String suit);

    // void createAndShowGUI();

    // void addAddPlayerButton (Container contentPane);
    
    // // when clicked, tell controller to deal cards to players
    // void addDealCardsButton (Container contentPane);
    
    // // when clicked, tell controller to flip cards and determine who won
    // void addFindWinnerButton(Container contentPane);
    
    // // a simple place to display what the controller is telling us
    // // very similar to our command line version    
    // void addControllerCommandTracker(Container contentPane);
	
	// // make sure that every time something is added to the text area,
	// // scroll down to the bottom so that it is visible
	// // textArea control does not have an auto-scroll option
	// // so we have to do it ourselves
	// void appendText (String text);
    
    // // all controls are added so they are centered horizontally in the area
    // void addCenteredComponent(JComponent component, Container contentPane);
}
