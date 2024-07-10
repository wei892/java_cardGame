package com.openclassrooms.cardgame.games;

import java.util.List;

import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;

public class HighCardGameEvaluator implements GameEvaluator{
    public Player evaluateWinner(List<Player> players){
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

        return bestPlayer;
    }
}
