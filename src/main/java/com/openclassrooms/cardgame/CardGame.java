package com.openclassrooms.cardgame;

import com.openclassrooms.cardgame.DeckFactory.DeckType;
import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.games.HighCardGameEvaluator;
// import com.openclassrooms.cardgame.model.Deck;
// import com.openclassrooms.cardgame.view.CommandLineView;
import com.openclassrooms.cardgame.view.GameSwing;

public class CardGame {
    public static void main(String[] args) {
        GameSwing gs = new GameSwing();
        gs.createAndShowGUI();
        GameController gc = new GameController(gs, 
        DeckFactory.makeDeck(DeckType.Normal), 
        new HighCardGameEvaluator());
        gc.run();
    }
}
