package com.openclassrooms.cardgame.games;

import java.util.List;

import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.PlayingCard;

public class HighCardGameEvaluator implements GameEvaluator{
    public IPlayer evaluateWinner(List<IPlayer> players){
        IPlayer bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (IPlayer player : players){
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
